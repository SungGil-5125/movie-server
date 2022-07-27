package com.project.watcha.global.exception.exceptions;

import com.project.watcha.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class UsedEmailException extends RuntimeException {

    private ErrorCode errorCode;

    public UsedEmailException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
