package com.seminar.yes24.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import com.seminar.yes24.repository.ShowRepository;
import lombok.Getter;

@Getter
public class ShowRankingDto {
    private Long id;
    private String title;
    private String period;
    private String place;
    private String genre;
    private String image;

    @QueryProjection
    public ShowRankingDto(Long id,
                          String title,
                          String period,
                          String place,
                          String genre,
                          String image) {
        this.id = id;
        this.title = title;
        this.period = period;
        this.place = place;
        this.genre = genre;

        this.image = image;
    }



}
