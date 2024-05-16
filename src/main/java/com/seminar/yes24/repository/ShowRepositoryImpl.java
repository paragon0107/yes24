package com.seminar.yes24.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.seminar.yes24.domain.QShow;
import com.seminar.yes24.domain.Show;
import jakarta.persistence.EntityManager;


import java.util.List;

import static com.seminar.yes24.domain.QShow.show;

public class ShowRepositoryImpl implements ShowRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public ShowRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Show> getRankByGenre(String genre){


        return queryFactory
                .selectFrom(show)
                .where(show.genre.eq(genre))
                .orderBy(show.ticketSales.asc())
                .limit(3)
                .fetch();
    }
}
