package com.project.watcha.global.response.result;

import lombok.Getter;

@Getter
public class SingleResult<T> extends CommonResultResponse {

    private T result;

    public SingleResult(CommonResultResponse commonResultResponse, T result) {
        super(commonResultResponse.isSuccess(), commonResultResponse.getMessage(), commonResultResponse.getStatus());
        this.result = result;
    }
}
