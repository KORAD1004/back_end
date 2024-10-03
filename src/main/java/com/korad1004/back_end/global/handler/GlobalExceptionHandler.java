package com.korad1004.back_end.global.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handleTypeMismatchException(MethodArgumentTypeMismatchException exception) {
        String errorMessage = "잘못된 요청: '" + exception.getValue() + "'의 타입이 잘못되었습니다.";
        return ResponseEntity.badRequest().body(errorMessage);
    }
}
