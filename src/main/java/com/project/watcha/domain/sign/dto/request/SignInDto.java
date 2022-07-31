package com.project.watcha.domain.sign.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignInDto {

    @Email
    @Pattern(regexp = "^\\w+@\\w+\\.\\w+(\\.\\w+)?")
    private String email;

    @Size(min = 10)
    private String password;
}
