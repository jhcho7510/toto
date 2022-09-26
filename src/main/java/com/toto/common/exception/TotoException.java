package com.toto.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class TotoException extends RuntimeException {
    public TotoException(String message) {
        super(message);
    }
}
