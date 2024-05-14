package com.seminar.yes24.dto.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.seminar.yes24.exception.CustomException;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;

public record ResponseDto<T>(
        @JsonIgnore HttpStatus httpStatus,
        @NotNull boolean success,
        @NotNull String message,
        @Nullable T data,
        @Nullable ExceptionDto error
) {
    public static <T> ResponseDto<T> ok(String message, T data) {
        return new ResponseDto<>(
                HttpStatus.OK,
                true,
                message,
                data,
                null
        );
    }

    public static <T> ResponseDto<T> created(String message, T data) {
        return new ResponseDto<>(
                HttpStatus.CREATED,
                true,
                message,
                data,
                null
        );
    }

    public static ResponseDto<Object> fail(String message, @NotNull CustomException e){
        return new ResponseDto<>(
                e.getErrorCode().getHttpStatus(),
                false,
                message,
                null,
                ExceptionDto.of(e.getErrorCode())
        );
    }
}
