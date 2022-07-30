package com.project.watcha.domain.sign.service.Impl;

import com.project.watcha.domain.sign.dto.request.RefreshTokenDto;
import com.project.watcha.domain.sign.service.RefreshTokenService;
import com.project.watcha.domain.user.User;
import com.project.watcha.domain.user.repository.UserRepository;
import com.project.watcha.global.exception.exceptions.InvalidTokenException;
import com.project.watcha.global.exception.exceptions.RefreshTokenExpirationException;
import com.project.watcha.global.exception.exceptions.UserNotFoundException;
import com.project.watcha.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.project.watcha.global.exception.ErrorCode.*;

@Service
@RequiredArgsConstructor
public class RefreshTokenServiceImpl implements RefreshTokenService {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    @Override
    public Map<String, String> refreshToken(String refreshToken, RefreshTokenDto refreshTokenDto) {

        Map<String, String> token = new HashMap<>();

        if(!jwtTokenProvider.isExpired(refreshToken)) {

            String email = refreshTokenDto.getEmail();
            User user = userRepository.findByEmail(email)
                    .orElseThrow(() -> new UserNotFoundException("계정을 찾을 수 없습니다.", USER_NOT_FOUND));

            if (user.getRefreshToken() == null) {
                throw new InvalidTokenException(INVALID_TOKEN);
            }

            String accessToken = jwtTokenProvider.generateAccessToken(user.getEmail());
            token.put("accessToken", accessToken);

            return token;
        }

        throw new RefreshTokenExpirationException("만료 된 refreshToken 입니다.", REFRESH_TOKEN_EXPIRATION);
    }
}
