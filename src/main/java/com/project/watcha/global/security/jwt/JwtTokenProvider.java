package com.project.watcha.global.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

    @Value("${jwt.secret}")
    private String secretKey;

    private static final Long ACCESS_TOKEN_EXPIRED_TIME = 1000 * 60 * 60 * 3L; // 만료 시간 3시간
    private static final Long REFRESH_TOKEN_EXPIRED_TIME = 14 * 24 * 60 * 60 * 1000L; // 만료 시간 2주

    @AllArgsConstructor
    enum TokenType {
        ACCESS_TOKEN("accessToken"),
        REFRESH_TOKEN("refreshToken");

        private String value;
    }

//    @AllArgsConstructor
//    enum TokenClaimName {
//        TOKEN_TYPE("tokenType");
//
//        private String value;
//    }

    private Key getSigninKey(String secretKey) {
        byte keyByte[] = secretKey.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyByte);
    }

    public Claims extractAllClaims(String token) throws ExpiredJwtException, IllegalStateException, UnsupportedOperationException {
        return Jwts.parserBuilder()
                .setSigningKey(getSigninKey(secretKey))
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String getUserEmail(String token) {
        return extractAllClaims(token).getSubject();
    }

    public String getTokenType(String token) {
        return extractAllClaims(token).get("tokenType", String.class);
    }

    public Boolean isExpired(String token) {
        try {
            extractAllClaims(token).getExpiration();
            return false;
        } catch (ExpiredJwtException e) {
            return true;
        }
    }

    private String doGenerateToken(String email, TokenType tokenType, Long expiredTime) {
        Claims claims = Jwts.claims().setSubject(email);
        claims.put("tokenType", tokenType.value);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date((System.currentTimeMillis())))
                .setExpiration(new Date(System.currentTimeMillis() + expiredTime))
                .signWith(getSigninKey(secretKey), SignatureAlgorithm.HS256)
                .compact();
    }

    public String generateAccessToken(String email) {
        return doGenerateToken(email, TokenType.ACCESS_TOKEN, ACCESS_TOKEN_EXPIRED_TIME);
    }

    public String generateRefreshToken(String email) {
        return doGenerateToken(email, TokenType.REFRESH_TOKEN, REFRESH_TOKEN_EXPIRED_TIME);
    }

    public String getRefreshToken(HttpServletRequest request) {
        String refreshToken = request.getHeader("RefreshToken");
        if (refreshToken != null && !isExpired(refreshToken)) {
            return refreshToken;
        } else {
            return null;
        }
    }
}
