package com.seminar.yes24.repository;

import com.seminar.yes24.domain.RunShow;
import com.seminar.yes24.domain.Show;
import java.util.List;

public interface RunShowRepositoryCustom {
    List<RunShow> geRunShowByShow(List<Show> shows);
}
