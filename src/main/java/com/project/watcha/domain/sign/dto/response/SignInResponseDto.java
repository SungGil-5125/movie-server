package com.project.watcha.domain.sign.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class SignInResponseDto {

    private String accessToken;
    private String refreshToken;
}
