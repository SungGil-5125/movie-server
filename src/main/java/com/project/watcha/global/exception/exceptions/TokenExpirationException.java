package com.project.watcha.global.exception.exceptions;

import com.project.watcha.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class TokenExpirationException extends RuntimeException {

    private ErrorCode errorCode;

    public TokenExpirationException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
