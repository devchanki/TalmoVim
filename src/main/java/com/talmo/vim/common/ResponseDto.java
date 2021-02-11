package com.talmo.vim.common;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ResponseDto {
    ResponseStatus status;
    @Expose
    String message;
    Object data;

    public ResponseDto() {
        status = ResponseStatus.NONE;
        message = null;
        data = null;
    }

    @Override
    public String toString() {
        return "{" +
                    "status=" + status +
                    ", message='" + message + '\'' +
                    ", data=" + data +
                '}';
    }
}