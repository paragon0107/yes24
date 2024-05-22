package com.seminar.yes24.dto.response;

import com.seminar.yes24.domain.RunShow;
import com.seminar.yes24.domain.Show;
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
        int runTime,
        int likeCount
) {
    public static RunShowFindDto of(Show show, RunShow runShow){
       return new RunShowFindDto(
                runShow.getId(),
                show.getGenre(),
                show.getTitle(),
                runShow.getPeriod(),
                runShow.getLocation(),
                runShow.getPlace(),
                show.getImg(),
                show.getFilmRate(),
                runShow.getRunTime(),
               runShow.getLikeCount()
        );
    }
}
