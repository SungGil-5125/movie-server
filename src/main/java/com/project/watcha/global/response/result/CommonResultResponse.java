package com.project.watcha.global.response.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommonResultResponse {

    private boolean success;
    private String message;
    private int status;
}
