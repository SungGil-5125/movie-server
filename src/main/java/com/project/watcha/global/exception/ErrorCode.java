package com.project.watcha.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    /* USER */
    USER_NOT_FOUND(404, "계정을 찾을 수 없습니다."),
    USED_EMAIL(409, "사용 중인 이메일 입니다."),
    PASSWORD_NOT_CORRECT(400, "비밀번호가 맞지 않습니다."),

    /* TOKEN */
    INVALID_TOKEN(403, "유효 하지 않은 Token 입니다."),
    TOKEN_EXPIRATION(403, "만료된 Token 입니다."),
    REFRESH_TOKEN_EXPIRATION(403, "만료 된 refreshToken 입니다."),

    /* ACTOR */
    ACTOR_NOT_FOUND(404, "등록되지 않은 배우가 있습니다."),

    /* DIRECTOR */
    DIRECTOR_NOT_FOUND(404, "등록되지 않은 감독이 있습니다."),

    /*  MOVIE */
    MOVIE_NOT_FOUND(404, "영화를 찾을 수 없습니다.")
    ;

    private int status;
    private String message;
}
