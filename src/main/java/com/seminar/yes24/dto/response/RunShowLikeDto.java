package com.seminar.yes24.dto.response;

public record RunShowLikeDto(
        boolean isLike
) {
    public static RunShowLikeDto of(boolean isLike) {
        return new RunShowLikeDto(isLike);
    }
}
