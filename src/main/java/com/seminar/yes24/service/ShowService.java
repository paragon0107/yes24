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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
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
        List<Show> shows = showRepository.findAll(PageRequest.of(0, 12)).getContent();
        System.out.println(shows.size());

        return shows.stream()
                .map(show -> {
                    RunShow fastRunShow = runShowRepository.findEarliestRunShowByShowId(show.getId());
                    String formattedPeriod = formatPeriod(fastRunShow.getPeriod());
                    System.out.println(formattedPeriod);
                    return new ShowDataDto(
                            show.getId(),
                            show.getTitle(),
                            show.getSubTitle(),
                            show.getImg(),
                            formattedPeriod,
                            fastRunShow.getPlace()
                    );
                })
                .collect(Collectors.toList());
    }

    public static String formatPeriod(String period) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy.M.d");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String[] dates = period.split(" ~ ");
        LocalDate startDate = LocalDate.parse(dates[0].trim(), inputFormatter);
        LocalDate endDate = LocalDate.parse(dates[1].trim(), inputFormatter);
        String formattedStartDate = startDate.format(outputFormatter);
        String formattedEndDate = endDate.format(outputFormatter);
        return formattedStartDate+formattedEndDate;
    }

    @Transactional(readOnly = true)
    public List<ShowRankingDto> getShowRanking(){
        List<ShowRankingDto> result = new ArrayList<>();
        Arrays.stream(Genre.values())
                .forEach(genre -> result.addAll(showRepositoryImpl.getShowByGenre(genre.getGenreName())));
                //.forEach(genre -> result.addAll(DeduplicationUtils.deduplication(showRepository.getShowByTest(genre.getGenreName()),ShowRankingDto::getId).subList(0,3)));
        return result;
    }
}
