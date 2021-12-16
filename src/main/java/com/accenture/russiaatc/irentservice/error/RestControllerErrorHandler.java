package com.accenture.russiaatc.irentservice.error;

import com.accenture.russiaatc.irentservice.model.dto.Error.ErrorDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@Slf4j
public class RestControllerErrorHandler {
    @ExceptionHandler(BusinessRuntimeException.class)
    public ResponseEntity<ErrorDto> handleBusinessException(BusinessRuntimeException ex) {
        log.error(ex.getMessage(), ex);
        ErrorDto error = new ErrorDto(ex.getErrorCode().getCode(), ex.getMessage());
        return new ResponseEntity<>(error, ex.getErrorCode().getHttpStatus());
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDto handleAnyException(Throwable ex) {
        log.error(ex.getMessage(), ex);
        return new ErrorDto(ErrorCodeEnum.INTERNAL_SERVER_ERROR.getCode(), ex.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        StringBuilder sb = new StringBuilder();
        e.getBindingResult().getFieldErrors()
                .forEach(fieldError -> sb.append(String.format("Поле %s.%s: %s; ",
                        fieldError.getObjectName(), fieldError.getField(), fieldError.getDefaultMessage())));
        return new ErrorDto(ErrorCodeEnum.VALIDATION_ERROR.getCode(), sb.toString());
    }
}
