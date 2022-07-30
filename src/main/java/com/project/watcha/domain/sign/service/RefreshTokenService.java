package com.project.watcha.domain.sign.service;

import com.project.watcha.domain.sign.dto.request.RefreshTokenDto;

import java.util.Map;

public interface RefreshTokenService {

    Map<String, String> refreshToken(String refreshToken, RefreshTokenDto refreshTokenDto);
}
