package com.seminar.yes24.repository;

import com.seminar.yes24.domain.RunShow;
import com.seminar.yes24.domain.Show;
import com.seminar.yes24.exception.CustomException;
import com.seminar.yes24.exception.ErrorCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RunShowRepository extends JpaRepository<RunShow, Long> {

    default RunShow findRunShowById(Long id) {
        return findById(id)
                .orElseThrow(
                        () -> new CustomException(ErrorCode.RUNSHOW_NOR_FOUND)
                );
    }
}
