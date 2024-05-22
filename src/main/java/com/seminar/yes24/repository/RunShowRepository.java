package com.seminar.yes24.repository;

import com.seminar.yes24.domain.RunShow;
import com.seminar.yes24.domain.Show;
import com.seminar.yes24.exception.CustomException;
import com.seminar.yes24.exception.ErrorCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RunShowRepository extends JpaRepository<RunShow, Long> ,RunShowRepositoryCustom{

    default RunShow findRunShowById(Long id) {
        return findById(id)
                .orElseThrow(
                        () -> new CustomException(ErrorCode.RUNSHOW_NOT_FOUND)
                );
    }
    @Query("SELECT rs FROM RunShow rs WHERE rs.show.id = :showId ORDER BY SUBSTRING(rs.period, 1, 10) ASC")
    List<RunShow> findRunShowsByShowIdOrderedByStartDate(Long showId);
    default RunShow findEarliestRunShowByShowId(Long showId) {
        return findRunShowsByShowIdOrderedByStartDate(showId).stream()
                .findFirst()
                .orElseThrow(() -> new CustomException(ErrorCode.RUNSHOW_NOT_FOUND));
    }
    List<RunShow> findByShowId(Long showId);
    List<RunShow> findByLocationContaining(String location);

}
