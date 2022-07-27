package com.project.watcha.global.exception.exceptions;

import com.project.watcha.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class UserNotFoundException extends RuntimeException {

    private ErrorCode errorCode;

    public UserNotFoundException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
