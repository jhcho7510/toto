package com.toto.common.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TotoValidationResponse {
    private boolean success;
    private String message;
    private Object data;

    public TotoValidationResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }


}
