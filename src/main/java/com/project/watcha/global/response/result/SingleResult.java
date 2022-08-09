package com.project.watcha.global.response.result;

import lombok.Getter;

@Getter
public class SingleResult<T> extends CommonResultResponse {

    private T data;

    public SingleResult(CommonResultResponse commonResultResponse, T data) {
        super(commonResultResponse.isSuccess(), commonResultResponse.getMessage(), commonResultResponse.getStatus());
        this.data = data;
    }

}
