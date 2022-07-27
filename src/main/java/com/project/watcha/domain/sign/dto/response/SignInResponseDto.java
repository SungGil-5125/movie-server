package com.project.watcha.domain.sign.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignInResponseDto {

    private String accessToken;
    private String refreshToken;
}
