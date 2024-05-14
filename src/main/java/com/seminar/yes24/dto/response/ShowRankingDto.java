package com.seminar.yes24.dto.response;

public record ShowRankingDto(
        Long id,
        String title,
        String period,
        String place,
        String genre,
        int ranking,
        String image
) {
}
