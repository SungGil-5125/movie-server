package com.project.watcha.global.exception.handler;

import com.project.watcha.global.exception.ErrorCode;
import com.project.watcha.global.exception.ErrorResponse;
import com.project.watcha.global.exception.exceptions.PasswordNotCorrectException;
import com.project.watcha.global.exception.exceptions.UsedEmailException;
import com.project.watcha.global.exception.exceptions.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> UserNotFoundException(HttpServletRequest request, UserNotFoundException e) {
        printException(request, e.getErrorCode());
        ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(UsedEmailException.class)
    public ResponseEntity<ErrorResponse> UsedEmailException(HttpServletRequest request, UsedEmailException e) {
        printException(request, e.getErrorCode());
        ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(PasswordNotCorrectException.class)
    public ResponseEntity<ErrorResponse> PasswordNotCorrectException(HttpServletRequest request, PasswordNotCorrectException e) {
        printException(request, e.getErrorCode());
        ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }



    public void printException(HttpServletRequest request, ErrorCode errorCode) {
        log.error("[ " + request.getRequestURI() + " 에서 { " + errorCode + " } 발생 ]");
    }
}
