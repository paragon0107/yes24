package com.seminar.yes24.repository;

import com.seminar.yes24.domain.Show;
import com.seminar.yes24.domain.enums.Genre;
import com.seminar.yes24.dto.response.ShowRankingDto;
import java.util.List;

public interface ShowRepositoryCustom {
    List<ShowRankingDto> getShowByGenre(String genre);

}
