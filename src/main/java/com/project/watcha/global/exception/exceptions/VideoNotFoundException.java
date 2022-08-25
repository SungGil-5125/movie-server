package com.project.watcha.global.exception.exceptions;

import com.project.watcha.global.exception.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class VideoNotFoundException extends RuntimeException {

    private ErrorCode errorCode;

}
