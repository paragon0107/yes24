package com.seminar.yes24.service;

import com.seminar.yes24.domain.*;
import com.seminar.yes24.dto.response.RunShowFindDto;
import com.seminar.yes24.dto.response.RunShowLikeDto;
import com.seminar.yes24.dto.response.RunShowSearchDto;
import com.seminar.yes24.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RunShowService {
    private final MemberRepository memberRepository;
    private final RunShowRepository runShowRepository;
    private final BookingRepository bookingRepository;
    private final ShowRepository showRepository;
    private final LikesRepository likesRepository;
    public RunShowFindDto findRunShowById(Long runShowId){
        RunShow runShow = runShowRepository.findRunShowById(runShowId);
        return RunShowFindDto.of(showRepository.findShowById(runShow.getShow().getId()), runShowRepository.findRunShowById(runShowId));//<-?
    }

    @Transactional
    public Long saveBookingById(Long memberId,Long runShowId){
        Member member = memberRepository.findMemberById(memberId);
        RunShow runShow = runShowRepository.findRunShowById(runShowId);
        return bookingRepository.save(Booking.create(member,runShow)).getId();
    }

    @Transactional(readOnly = true)
    public List<RunShowSearchDto> findRunShowByKeyWord(String query) {
        List<Show> shows = showRepository.findByTitleContaining(query);
        List<RunShowSearchDto> runShowsFromTitles = shows.stream()
                .flatMap(show -> runShowRepository.findByShowId(show.getId()).stream())
                .map(runShow -> RunShowSearchDto.of(showRepository.findShowById(runShow.getShow().getId()), runShow))
                .collect(Collectors.toList());

        List<RunShow> runShows = runShowRepository.findByLocationContaining(query);
        List<RunShowSearchDto> runShowsFromLocations = runShows.stream()
                .map(runShow -> RunShowSearchDto.of(showRepository.findShowById(runShow.getShow().getId()), runShow))
                .toList();

        runShowsFromTitles.addAll(runShowsFromLocations);
        return runShowsFromTitles;
    }

    @Transactional
    public RunShowLikeDto likeRunShow(Long runShowId, Long memberId){
        RunShow runShow = runShowRepository.findRunShowById(runShowId);
        Member member = memberRepository.findMemberById(memberId);
        Optional<Like> likeOptional = likesRepository.findByMemberAndRunShow(member, runShow);
        boolean isLike;
        if (likeOptional.isPresent()) {
            likesRepository.deleteByMemberAndRunShow(member, runShow);
            isLike = false;
        } else {
            Like like = Like.create(member, runShow);
            likesRepository.save(like);
            isLike = true;
        }
        return RunShowLikeDto.of(isLike);
    }
}
