package com.talmo.vim.follow.util.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SampleAjaxRestResponse extends AjaxResponse {
	private int count;			// 데이터 개수
	private String status;	// 서비스 처리 결과
	private String message; 	// 처리 결과 메세지
	private Object data;		//result data
}
