package com.project.watcha.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    /* USER */
    USER_NOT_FOUND(404, "계정을 찾을 수 없습니다."),
    USED_EMAIL(409, "사용 중인 이메일 입니다."),
    PASSWORD_NOT_CORRECT(400, "비밀번호가 맞지 않습니다.")
    ;

    private int status;
    private String message;
}
