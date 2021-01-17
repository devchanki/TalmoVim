package com.talmo.vim.follow.util.response;

import lombok.Data;

@Data
public abstract class AjaxResponse {
	protected String status;	// 서비스 처리 결과
	protected String message; 	// 처리 결과 메세지
}
