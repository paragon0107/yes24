package com.seminar.yes24.dto.response;

import com.seminar.yes24.domain.RunShow;
import com.seminar.yes24.domain.Show;

public record RunShowSearchDto(
        Long id,
        String title,
        String period,
        String location,
        String place,
        String genre,
        String image
) {
    public static RunShowSearchDto of(Show show, RunShow runShow){
        return new RunShowSearchDto(
                runShow.getId(),
                show.getTitle(),
                runShow.getPeriod(),
                runShow.getLocation(),
                runShow.getPlace(),
                show.getGenre(),
                show.getImg()
        );
    }
}