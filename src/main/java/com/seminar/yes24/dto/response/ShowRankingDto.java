package com.seminar.yes24.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import com.seminar.yes24.repository.ShowRepository;
import com.seminar.yes24.service.ShowService;
import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
public class ShowRankingDto {

    @Id
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
        this.period = ShowService.formatPeriod(period);
        this.place = place;
        this.genre = genre;
        this.image = image;
    }



}
