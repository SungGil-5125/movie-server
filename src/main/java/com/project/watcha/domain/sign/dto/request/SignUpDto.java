package com.project.watcha.domain.sign.dto.request;

import com.project.watcha.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Getter
public class SignUpDto {

//    @Size(min = 2, max = 5)
    private String userName;

//    @Pattern(regexp = "^\\w+@\\w+\\.\\w+(\\.\\w+)?")
    private String email;

//    @Pattern(regexp = "^[\\w!@#$%^&*]{2,}&")
//    @Size(min = 10)
    private String password;

    public User toEntity(String password) {
        return User.builder()
                .userName(userName)
                .email(email)
                .password(password)
                .build();
    }
}
