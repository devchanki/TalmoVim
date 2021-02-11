package com.talmo.vim.common;

public enum ResponseStatus {
    NONE,                           //미설정 (기본 Default 값)
    NOT_IMPLEMENTED,                //미구현 (controller 만 구현되어있거나 미구현된 서비스의 경우)
    SUCCESS,                        //정상 실행
    FAIL,                           //실패
    ILLIEGAL_ACCESS,                //비정상 접근(접근 권한 없음)
    ILLIEGAL_PARAMETER;             //비정상 파라매터(전달받은 파라메터가 부적절함)
}

