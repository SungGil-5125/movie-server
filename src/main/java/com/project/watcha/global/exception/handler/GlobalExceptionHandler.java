package com.project.watcha.global.exception.handler;

import com.project.watcha.global.exception.ErrorCode;
import com.project.watcha.global.exception.ErrorResponse;
import com.project.watcha.global.exception.exceptions.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    @ExceptionHandler(RefreshTokenExpirationException.class)
    public ResponseEntity<ErrorResponse> refreshTokenIsExpiredException(HttpServletRequest request, RefreshTokenExpirationException e) {
        printException(request, e.getErrorCode());
        ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(PeopleNotFoundException.class)
    public ResponseEntity<ErrorResponse> directorNotFoundException(HttpServletRequest request, PeopleNotFoundException e) {
        printException(request, e.getErrorCode());
        ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(VideoNotFoundException.class)
    public ResponseEntity<ErrorResponse> movieNotFoundException(HttpServletRequest request, VideoNotFoundException e) {
        printException(request, e.getErrorCode());
        ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> processValidationException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        StringBuilder stringBuilder = new StringBuilder();

        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            stringBuilder.append(fieldError.getField()).append(" : ");
            stringBuilder.append(fieldError.getDefaultMessage());
            stringBuilder.append(", ");
        }

        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(", "));
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(" "));
        ErrorResponse errorResponse = new ErrorResponse(stringBuilder.toString(), HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    public void printException(HttpServletRequest request, ErrorCode errorCode) {
        log.error(request.getRequestURI() + " 에서 { " + errorCode + " } 발생");
    }
}
