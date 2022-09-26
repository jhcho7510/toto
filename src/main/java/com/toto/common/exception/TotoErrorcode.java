package com.toto.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum TotoErrorcode {

    /** 400 */
    NOT_FOUND(HttpStatus.BAD_REQUEST,"없음.");

    private final HttpStatus httpStatus;
    private final String description;
}
