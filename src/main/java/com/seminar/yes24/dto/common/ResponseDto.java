package com.seminar.yes24.dto.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.seminar.yes24.exception.CustomException;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;

public record ResponseDto<T>(
        @JsonIgnore HttpStatus httpStatus,
        @NotNull boolean success,
        @Nullable T data,
        @Nullable ExceptionDto error
) {
    public static <T> ResponseDto<T> ok(T data) {
        return new ResponseDto<>(
                HttpStatus.OK,
                true,
                data,
                null
        );
    }

    public static <T> ResponseDto<T> created(T data) {
        return new ResponseDto<>(
                HttpStatus.CREATED,
                true,
                data,
                null
        );
    }

    public static ResponseDto<Object> fail(String message, @NotNull CustomException e){
        return new ResponseDto<>(
                e.getErrorCode().getHttpStatus(),
                false,
                null,
                ExceptionDto.of(e.getErrorCode())
        );
    }
}
