package com.talmo.vim.common;

public enum ResponseStatus {
    NOT_IMPLEMENTED,                //미구현 (controller 만 구현되어있거나 미구현된 서비스의 경우)
    SUCCESS,                        //정상 실행
    FAIL,                           //실패
    ILLEGAL_ACCESS,                //비정상 접근(접근 권한 없음)
    ILLEGAL_PARAMETER;             //비정상 파라매터(전달받은 파라메터가 부적절함)
}

