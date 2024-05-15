package com.seminar.yes24.dto.response;

import com.seminar.yes24.domain.RunShow;

public record RunShowSearchDto(
        Long id,
        String title,
        String period,
        String location,
        String place,
        String genre,
        String image
) {
    public static RunShowSearchDto of(RunShow runShow){
        return new RunShowSearchDto(
                runShow.getId(),
                runShow.getTitle(),
                runShow.getPeriod(),
                runShow.getLocation(),
                runShow.getPlace(),
                runShow.getGenre(),
                runShow.getImg()
        );
    }
}