package com.ltns.rest_area.domain.post;

import com.ltns.rest_area.domain.VO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostVO implements VO {
	
	/*요청 타입*/
	private String type;	//count, one, list, all
	
	/*페이지 요청 데이터*/
	private String orderBy;	 //요청 정렬 방식	
	
	private int fromRow;	//가져올 시작 row
	private int numOfRows;	//한 페이지에 리스트할 dto 갯수
	
	private int pageNo;	//바꿀 페이지
	
	/*데이터 객체형*/
	private DTO dto;
	private List<DTO> list;
	private Object obj;
	
	/*데이터 낱개형*/
	private int post_id;
	private String post_title;
	private String post_contents;
	private int um_uid;
	private String um_username;
	private String post_regdate;
	private String ra_code;	//휴게소 정보
	private String post_reported;
}
