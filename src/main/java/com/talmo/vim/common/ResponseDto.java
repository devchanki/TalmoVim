package com.talmo.vim.common;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ResponseDto {
    ResponseStatus status;
    String message;
    Object data;

    public ResponseDto() {
        status = ResponseStatus.NOT_IMPLEMENTED;
        message = "This Control is not Implemented yet";
        data = null;
    }

    @Builder
    public ResponseDto(ResponseStatus status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}