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
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.project.watcha.global.exception.ErrorCode.*;

@Service
@RequiredArgsConstructor
public class SignServiceImpl implements SignService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Long register(SignUpDto signUpDto) {
        Optional<User> findByEmail = userRepository.findByEmail(signUpDto.getEmail());
        if(findByEmail.isPresent()){
            throw new UsedEmailException("이미 사용 중인 이메일 입니다.", USED_EMAIL);
        }
        User user = signUpDto.toEntity(passwordEncoder.encode(signUpDto.getPassword()));
        return userRepository.save(user).getUser_id();
    }

    @Override
    public SignInResponseDto login(SignInDto signInDto) {
         User user = userRepository.findByEmail(signInDto.getEmail())
                 .orElseThrow(() -> new UserNotFoundException("사용자를 찾을 수 없습니다.", USER_NOT_FOUND));

         if(!passwordEncoder.matches(signInDto.getPassword(), user.getPassword())) {
             throw new PasswordNotCorrectException(PASSWORD_NOT_CORRECT);
         }


    }


}
