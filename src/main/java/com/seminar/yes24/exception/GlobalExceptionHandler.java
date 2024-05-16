package com.seminar.yes24.exception;

import com.seminar.yes24.dto.common.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    // 커스텀 예외
    @ExceptionHandler(value = {CustomException.class})
    public ResponseEntity<ResponseDto<Object>> handleCustomException(CustomException e) {
        return ResponseEntity
                .status(e.getErrorCode().getHttpStatus())
                .body(ResponseDto.fail(e.getErrorCode().getMessage(), e));
    }
}
