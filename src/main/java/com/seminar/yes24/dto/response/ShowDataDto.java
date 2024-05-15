package com.seminar.yes24.dto.response;

public record ShowDataDto(
        Long id,
        String title,
        String subTitle,
        String image,
        String period,
        String place
) {
}
