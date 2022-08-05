package com.project.watcha.global.exception.exceptions;

import com.project.watcha.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class ActorNotFoundException extends RuntimeException {

    private ErrorCode errorCode;

    public ActorNotFoundException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
