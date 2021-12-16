package com.accenture.russiaatc.irentservice.error;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.text.MessageFormat;

@RequiredArgsConstructor
public enum ErrorCodeEnum {
    INTERNAL_SERVER_ERROR("Внутренняя ошибка сервиса"),
    VALIDATION_ERROR("Ошибка валидации {0}"),
    USER_NO_FOUND("Пользователь не найден, id={0}", HttpStatus.NOT_FOUND),
    USER_CANT_RENT("Пользользователь не может создать аренду, id={0}"),
    TRANSPORT_NO_FOUND("Транспорт не найден, id={0}", HttpStatus.NOT_FOUND),
    TRANSPORT_NOT_AVAILABLE("Транспорт не доступен, id={0}", HttpStatus.NOT_FOUND);


    private HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    private final String messageTemplate;

    ErrorCodeEnum(String message,HttpStatus httpStatus ) {
        this.messageTemplate = message;
        this.httpStatus = httpStatus;

    }

    public String getMessageTemplate(Object ...args) {
        return MessageFormat.format(messageTemplate, args);
    }

    public int getCode () {
        return httpStatus.ordinal();
    }

    public HttpStatus getHttpStatus () {
        return httpStatus;
    }
}
