package com.seminar.yes24.service;

import com.seminar.yes24.domain.RunShow;
import com.seminar.yes24.domain.Show;
import com.seminar.yes24.domain.enums.Genre;
import com.seminar.yes24.dto.response.ShowDataDto;
import com.seminar.yes24.dto.response.ShowRankingDto;
import com.seminar.yes24.repository.RunShowRepository;
import com.seminar.yes24.repository.RunShowRepositoryImpl;
import com.seminar.yes24.repository.ShowRepository;
import com.seminar.yes24.repository.ShowRepositoryImpl;
import java.util.ArrayList;
import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShowService {
    private final ShowRepository showRepository;
    private final ShowRepositoryImpl showRepositoryImpl;
    private final RunShowRepository runShowRepository;
    private final RunShowRepositoryImpl runShowRepositoryImpl;

    @Transactional(readOnly = true)
    public List<ShowDataDto> getMainCarasel() {
        List<Show> shows = showRepository.findAll(PageRequest.of(0, 5)).getContent();
        return shows.stream()
                .map(show -> {
                    RunShow fastRunShow = runShowRepository.findEarliestRunShowByShowId(show.getId());
                    return new ShowDataDto(
                            show.getId(),
                            show.getTitle(),
                            show.getSubTitle(),
                            show.getImg(),
                            fastRunShow.getPeriod(),
                            fastRunShow.getPlace()
                    );
                })
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<List<ShowRankingDto>> getShowRanking(){
        List<List<ShowRankingDto>> result = new ArrayList<>();
        Arrays.stream(Genre.values()).forEach(genre -> result.add(showRepositoryImpl.getShowByGenre(genre.getGenreName())));
       return result;
    }
}
