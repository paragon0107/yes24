package com.seminar.yes24.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import com.seminar.yes24.domain.Show;
import com.seminar.yes24.dto.response.QShowRankingDto;
import com.seminar.yes24.dto.response.ShowRankingDto;
import com.seminar.yes24.service.ShowService;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

import static com.seminar.yes24.domain.QRunShow.runShow;
import static com.seminar.yes24.domain.QShow.show;

@Repository
public class ShowRepositoryImpl implements ShowRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public ShowRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<ShowRankingDto> getShowByGenre(String genre) {

        return queryFactory
                .from(show)
                .select(new QShowRankingDto(
                        show.id,
                        show.title,
                        runShow.period,
                        runShow.place,
                        show.genre,
                        show.img
                ))
                .leftJoin(runShow)
                .on(runShow.show.eq(show))
                .where(show.genre.eq(genre))
                .distinct()
                .fetch();
    }


}
