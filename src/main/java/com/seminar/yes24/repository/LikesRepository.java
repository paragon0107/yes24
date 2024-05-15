package com.seminar.yes24.repository;

import com.seminar.yes24.domain.Like;
import com.seminar.yes24.domain.Member;
import com.seminar.yes24.domain.RunShow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikesRepository extends JpaRepository<Like, Long> {
    Optional<Like> findByMemberAndRunShow(Member member, RunShow runShow);
    void deleteByMemberAndRunShow(Member member, RunShow runShow);
}
