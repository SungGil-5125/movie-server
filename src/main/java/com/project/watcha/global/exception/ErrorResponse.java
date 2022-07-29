package com.project.watcha.global.exception;

import lombok.Getter;

@Getter
public class ErrorResponse {

    private int status;
    private String message;

    public ErrorResponse(ErrorCode errorCode) {
        this.status = status;
        this.message = message;
    }

    public ErrorResponse(String message, int status) {
        this.message = message;
        this.status = status;
    }
}
