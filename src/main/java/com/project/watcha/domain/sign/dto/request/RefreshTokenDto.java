package com.project.watcha.domain.sign.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RefreshTokenDto {

    @Email
    @Pattern(regexp = "^\\w+@\\w+\\.\\w+(\\.\\w+)?", message = "이메일 형식이 아닙니다")
    @NotBlank
    private String email;
}
