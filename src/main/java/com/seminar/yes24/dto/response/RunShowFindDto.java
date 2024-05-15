package com.seminar.yes24.dto.response;

import com.seminar.yes24.domain.RunShow;
import com.seminar.yes24.repository.RunShowRepository;

public record RunShowFindDto(
        Long id,
        String genre,
        String title,
        String period,
        String location,
        String place,
        String imgUrl,
        int filmRating,
        int runTime
) {
    public static RunShowFindDto of(RunShow runShow){
       return new RunShowFindDto(
                runShow.getId(),
                runShow.getGenre(),
                runShow.getTitle(),
                runShow.getPeriod(),
                runShow.getLocation(),
                runShow.getPlace(),
                runShow.getImg(),
                runShow.getFilmRate(),
                runShow.getRunTime()
        );
    }
}
