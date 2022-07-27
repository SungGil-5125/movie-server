package com.project.watcha.domain.sign.service;

import com.project.watcha.domain.sign.dto.request.SignInDto;
import com.project.watcha.domain.sign.dto.request.SignUpDto;
import com.project.watcha.domain.sign.dto.response.SignInResponseDto;

public interface SignService {

    Long register(SignUpDto signUpDto);
    SignInResponseDto login(SignInDto signInDto);
}
