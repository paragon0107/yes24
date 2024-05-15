package com.seminar.yes24.service;

import com.seminar.yes24.domain.RunShow;
import com.seminar.yes24.domain.Show;
import com.seminar.yes24.dto.response.ShowDataDto;
import com.seminar.yes24.dto.response.ShowRankingDto;
import com.seminar.yes24.repository.RunShowRepository;
import com.seminar.yes24.repository.ShowRepository;
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
    private final RunShowRepository runShowRepository;

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

        return null;
    }
}
