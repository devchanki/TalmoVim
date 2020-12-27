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

	private String type;	//count, one, list, all
	
	private String orderBy;		
	
	private int fromRow;	//가져올 시작 row
	private int numOfRows;	//한 페이지에 리스트할 dto 갯수
	
	
	private int pageNo;	//바꿀 페이지
	
	//정보
	private int post_id;
	private String post_title;
	private String post_contents;
	private int um_uid;
	private String um_username;
	private String post_regdate;
	private String ra_code;	//휴게소 정보
	private String post_reported;
}
