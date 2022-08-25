package com.project.watcha.domain.sign.service.Impl;

import com.project.watcha.domain.sign.dto.request.SignInDto;
import com.project.watcha.domain.sign.dto.request.SignUpDto;
import com.project.watcha.domain.sign.dto.response.SignInResponseDto;
import com.project.watcha.domain.user.repository.UserRepository;
import com.project.watcha.domain.sign.service.SignService;
import com.project.watcha.domain.user.User;
import com.project.watcha.global.exception.exceptions.PasswordNotCorrectException;
import com.project.watcha.global.exception.exceptions.UsedEmailException;
import com.project.watcha.global.exception.exceptions.UserNotFoundException;
import com.project.watcha.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.project.watcha.global.exception.ErrorCode.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class SignServiceImpl implements SignService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    /**
    회원가입 로직
     @Requestbody : userName, email, password
     @return : user_id
     **/
    @Transactional
    @Override
    public Long register(SignUpDto signUpDto) {
        Optional<User> findByEmail = userRepository.findByEmail(signUpDto.getEmail());
        if(findByEmail.isPresent()){
            throw new UsedEmailException(USED_EMAIL);
        }
        User user = signUpDto.toEntity(passwordEncoder.encode(signUpDto.getPassword()));
        return userRepository.save(user).getUser_id();
    }

    /**
    로그인 로직
     @Requestbody : email, password
     @return : token - accessToken, refreshToken
     **/
    @Transactional
    @Override
    public SignInResponseDto login(SignInDto signInDto) {
        User user = userRepository.findByEmail(signInDto.getEmail())
                 .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));
        if(!passwordEncoder.matches(signInDto.getPassword(), user.getPassword())) {
             throw new PasswordNotCorrectException(PASSWORD_NOT_CORRECT);
        }
        return new SignInResponseDto(createToken(user));
    }

    /**
    토큰 생성 로직
     @Param : user
     @return : token - accessToken, refreshToken
     **/
    private Map<String, String> createToken(User user) {
        Map<String, String> token = new HashMap<>();
        final String accessToken = jwtTokenProvider.generateAccessToken(user.getEmail());
        final String refreshToken = jwtTokenProvider.generateRefreshToken(user.getEmail());
        user.updateRefreshToken(refreshToken);
        token.put("accessToken", accessToken);
        token.put("refreshToken", refreshToken);
        return token;
    }
}
