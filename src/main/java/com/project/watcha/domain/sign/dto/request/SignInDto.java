package com.project.watcha.domain.sign.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
public class SignInDto {

    @Size(min = 2, max = 5)
    private String userName;

    @Pattern(regexp = "^\\w+@\\w+\\.\\w+(\\.\\w+)?")
    private String email;

    @Pattern(regexp = "^[\\w!@#$%^&*]{2,}&")
    @Size(min = 10)
    private String password;
}
