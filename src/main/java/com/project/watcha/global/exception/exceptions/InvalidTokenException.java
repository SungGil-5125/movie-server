package com.project.watcha.global.exception.exceptions;

import com.project.watcha.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class InvalidTokenException extends RuntimeException {

    private ErrorCode errorCode;

    public InvalidTokenException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
