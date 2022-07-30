package com.project.watcha.domain.sign.dto.request;

import com.project.watcha.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class SignUpDto {

    @NotBlank
    @Size(min = 2, max = 5)
    private String userName;

    @NotBlank
    @Pattern(regexp = "^\\w+@\\w+\\.\\w+(\\.\\w+)?", message = "이메일 형식이 아닙니다")
    private String email;

    @NotBlank
//    @Pattern(regexp = "[\\w]{2,}", message = "영문, 숫자, 특문 중 2개 조합이여야 합니다") // 비밀번호 message적기
    @Size(min = 10, max = 20)
    private String password;

    public User toEntity(String password) {
        return User.builder()
                .userName(userName)
                .email(email)
                .password(password)
                .build();
    }
}
