package com.seminar.yes24.repository;

import com.seminar.yes24.domain.Show;
import com.seminar.yes24.dto.response.ShowRankingDto;
import com.seminar.yes24.exception.CustomException;
import com.seminar.yes24.exception.ErrorCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long>,ShowRepositoryCustom {
    default Show findShowById(Long id) {
        return findById(id)
                .orElseThrow(
                        () -> new CustomException(ErrorCode.SHOW_NOT_FOUND)
                );
    }
    List<Show> findByTitleContaining(String title);
    public List<Show> findTop3ShowByGenre(String genre);
    @Query("SELECT DISTINCT new com.seminar.yes24.dto.response.ShowRankingDto(s.id,s.title,rs.period,rs.place,s.genre,s.img)  FROM Show s Join RunShow rs ON rs.show = s WHERE s.genre = :genre")
    public List<ShowRankingDto> getShowByTest(String genre);
}
