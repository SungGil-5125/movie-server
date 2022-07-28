package com.project.watcha.global.security.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.watcha.global.exception.ErrorCode;
import com.project.watcha.global.exception.ErrorResponse;
import com.project.watcha.global.exception.exceptions.InvalidTokenException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.project.watcha.global.exception.ErrorCode.INVALID_TOKEN;
import static com.project.watcha.global.exception.ErrorCode.TOKEN_EXPIRATION;

@Component
@RequiredArgsConstructor
@Slf4j
public class ExceptionHandlerFilter extends OncePerRequestFilter {

    private final ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (ExpiredJwtException e) {
            log.error("[ ExceptionHandlerFilter ] 에서 ExpiredJwtException 발생");
            setErrorResponse(TOKEN_EXPIRATION, response);
        } catch (JwtException | IllegalStateException e) {
            log.error("[ ExceptionHandlerFilter ] 에서 JwtException 발생");
            setErrorResponse(INVALID_TOKEN, response);
        } catch (InvalidTokenException e) {
            log.error("[ ExceptionHandlerFilter ] 에서 InvalidTokenException 발생");
            setErrorResponse(INVALID_TOKEN, response);
        }
    }

    public void setErrorResponse(ErrorCode errorCode, HttpServletResponse response) throws IOException {
        response.setStatus(errorCode.getStatus());
        response.setContentType("application/json; charset=utf-8");
        ErrorResponse errorResponse = new ErrorResponse(errorCode);
        String errorResponseEntityToJson = objectMapper.writeValueAsString(errorResponse);
        response.getWriter().write(errorResponseEntityToJson);
    }
}
