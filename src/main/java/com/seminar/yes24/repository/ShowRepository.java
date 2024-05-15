package com.seminar.yes24.repository;

import com.seminar.yes24.domain.RunShow;
import com.seminar.yes24.domain.Show;
import com.seminar.yes24.exception.CustomException;
import com.seminar.yes24.exception.ErrorCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
    default Show findShowById(Long id) {
        return findById(id)
                .orElseThrow(
                        () -> new CustomException(ErrorCode.SHOW_NOT_FOUND)
                );
    }
}
