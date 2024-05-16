package com.seminar.yes24.dto.response;

import com.seminar.yes24.domain.RunShow;
import com.seminar.yes24.domain.Show;

public record ShowRankDto(
        Long id,
        String title,
        String period,
        String place,
        String genre,
        int rank,
        String imgUrl
) {
    public ShowRankDto of(Show show){
        return new ShowRankDto(
                show.getId(),
                show.getTitle(),
                "QWE",
                "qwe",
                show.getGenre(),
                1,
                "img"
        );

    }
}
