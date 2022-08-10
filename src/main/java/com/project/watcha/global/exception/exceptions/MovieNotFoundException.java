package com.project.watcha.global.exception.exceptions;

import com.project.watcha.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class MovieNotFoundException extends RuntimeException {

    private ErrorCode errorCode;

    public MovieNotFoundException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
