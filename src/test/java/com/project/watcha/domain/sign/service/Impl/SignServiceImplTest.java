package com.project.watcha.domain.sign.service.Impl;

import com.project.watcha.domain.sign.dto.request.SignUpDto;
import com.project.watcha.domain.user.repository.UserRepository;
import com.project.watcha.domain.sign.service.SignService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class SignServiceImplTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SignService signService;

    @Test
    @DisplayName("회원가입 테스트")
    void register() {

        // given
        SignUpDto signUpDto = new SignUpDto("김성길", "s21023@gsm.hs.kr", "kimsunggil2005!");

        // when
        Long register = signService.register(signUpDto);

        // then
        assertThat(register).isEqualTo(userRepository.findByEmail(signUpDto.getEmail()).orElseThrow().getUser_id());
    }
}