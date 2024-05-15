package com.seminar.yes24.service;

import com.seminar.yes24.domain.Booking;
import com.seminar.yes24.domain.Member;
import com.seminar.yes24.domain.RunShow;
import com.seminar.yes24.dto.response.RunShowFindDto;
import com.seminar.yes24.repository.BookingRepository;
import com.seminar.yes24.repository.MemberRepository;
import com.seminar.yes24.repository.RunShowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RunShowService {
    private final MemberRepository memberRepository;
    private final RunShowRepository runShowRepository;
    private final BookingRepository bookingRepository;
    private final MemberService memberService;
    public RunShowFindDto findRunShowById(Long runShowId){
        return RunShowFindDto.of(runShowRepository.findRunShowById(runShowId));
    }

    @Transactional
    public Long saveBookingById(Long memberId,Long runShowId){
        Member member = memberRepository.findMemberById(memberId);
        RunShow runShow = runShowRepository.findRunShowById(runShowId);
        return bookingRepository.save(Booking.create(member,runShow)).getId();
    }
}
