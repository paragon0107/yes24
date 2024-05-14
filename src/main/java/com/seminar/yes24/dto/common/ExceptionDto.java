package com.seminar.yes24.dto.common;

import com.seminar.yes24.exception.ErrorCode;
import org.springframework.http.HttpStatus;

public record ExceptionDto(
        HttpStatus code,
         String message
) {
    public static ExceptionDto of(ErrorCode errorCode){
        return new ExceptionDto(
                errorCode.getHttpStatus(),
                errorCode.getMessage());
    }
}
