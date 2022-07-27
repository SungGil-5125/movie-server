package com.project.watcha.global.response;

import com.project.watcha.global.response.result.CommonResultResponse;
import com.project.watcha.global.response.result.SingleResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class ResponseService {

    @Getter
    @AllArgsConstructor
    public enum CommonResponse{
        SUCCESS(true, "아싸뵹", 200);

        private boolean success;
        private String message;
        private int status;
    }

    public CommonResultResponse getSuccessResult() {
        return getCommonResultResponse();
    }

    public <T>SingleResult<T> getSingleResult(T data) {
        return new SingleResult<T>(getCommonResultResponse(), data);
    }

    private CommonResultResponse getCommonResultResponse() {
        return new CommonResultResponse(CommonResponse.SUCCESS.isSuccess(), CommonResponse.SUCCESS.getMessage(), CommonResponse.SUCCESS.getStatus());
    }
}
