package com.seminar.yes24.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.seminar.yes24.domain.RunShow;
import com.seminar.yes24.domain.Show;
import jakarta.persistence.EntityManager;

import java.util.List;

import static com.seminar.yes24.domain.QRunShow.runShow;
import static com.seminar.yes24.domain.QShow.show;

public class RunShowRepositoryImpl implements RunShowRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    public RunShowRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    public List<RunShow> geRunShowByShow(List<Show> shows){
        return queryFactory
                .select(runShow).distinct()
                .from(runShow)
                .leftJoin(runShow.show,show).fetchJoin()
                .where(show.in(shows))
                .fetch();
    }
}
