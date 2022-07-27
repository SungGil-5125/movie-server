package com.project.watcha.global.exception.exceptions;

import com.project.watcha.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class PasswordNotCorrectException extends RuntimeException {

    private ErrorCode errorCode;

    public PasswordNotCorrectException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
