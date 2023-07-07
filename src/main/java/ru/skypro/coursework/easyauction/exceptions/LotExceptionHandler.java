package ru.skypro.coursework.easyauction.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class LotExceptionHandler {

    @ExceptionHandler(LotNotFoundException.class)
    public ResponseEntity<?> handleNotFound(LotNotFoundException e) {
//        logger.error("Id не найден!)");
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Лот не найден!");
    }

    @ExceptionHandler(LotErrorStatusException.class)
    public ResponseEntity<?> handleNotFound(LotErrorStatusException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Лот в неверном статусе");
    }
}
