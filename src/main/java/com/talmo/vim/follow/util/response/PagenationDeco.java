package com.talmo.vim.follow.util.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PagenationDeco extends ResponseDecorator {
	private AjaxResponse ajaxResponse;
	
	private int totalCnt; //총 데이터 갯수
	
	private int pageNo; //현재 페이지
	private int numOfRows; //한 페이지에 리스트할 데이터 갯수
	private int totalPage; //총 페이지 갯수
	
	private int pagenationPage; //페이지네이션에 표시할 단추 갯수
	
	@Override
	public String toString() {
		return "AjaxList ("
				+ ajaxResponse
				+ "totalCnt=" + totalCnt + ", pageNo=" + pageNo + ", numOfRows=" + numOfRows + ", totalPage="
				+ totalPage + ", pagenationPage=" + pagenationPage
				+ ")";
	}
}
