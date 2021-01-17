package com.talmo.vim.follow.util.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FollowResultDTO extends ResultDTO{
	protected int count;			// 데이터 개수
	protected String status;	// 서비스 처리 결과
	protected String message; 	// 처리 결과 메세지
	protected Object data;		//result data
}
