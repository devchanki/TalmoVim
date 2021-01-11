package com.talmo.vim.follow;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talmo.vim.follow.util.response.AjaxResponse;
import com.talmo.vim.follow.util.response.AjaxRestResponse;

/* 메소드 명
 * {명령}{목적}{단위}
 * 
 * {명령}
 * select, insert, delete
 * accept : 수락 (업데이트)
 * 
 * {목적}
 * 팔로워 : 내게 팔로우한 사람
 * 팔로이 : 내가 팔로우한 사람
 * 
 * {단위}
 * cnt
 * default(=one)
 * list
 * 
 * */

@Service
public class FollowService {
	@Autowired
	FollowRepository dao;
	
	/*==================복합 서비스==================*/
	
	/*팔로우 명수 초기화 : 팔로워 명수, 팔로이 명수
	 * request{userId}
	 * */
	public AjaxResponse initFollowCnt(Map request) {
		//팔로우 갯수, 팔로이 갯수 함수 호출
		return null;
	}
	
	/*팔로워 체크 : 팔로워 명수, 팔로워 리스트
	 * request{userId}
	 * */
	public AjaxResponse initFollower(Map request) {
		//팔로워 명수, 팔로워 리스트 함수 호출
		return null;
	}
	
	/*팔로이 체크 : 팔로이 명수, 팔로이 리스트
	 * request{userId}
	 * */
	public AjaxResponse initFollowee(Map request) {
		//팔로이 명수, 팔로이 리스트 함수 호출
		return null;
	}
	
	/*상대 팔로우 체크 : 상대와 나와의 팔로워, 팔로이 관계 확인*/
	public AjaxResponse chkFollow(Map request) {
		//확인 함수 호출
		return null;
	}
	
	
	/*==================기본 서비스==================*/
	//팩토리 패턴의 직렬화 및 모듈화..
	
	/*팔로워 갯수
	 * request{userId}
	 * */
	public AjaxResponse selectFollowerCnt(Map request) {
		int _count=0;
		String _status="";
		String _message="";
		try {
			_count=dao.selectFollowerCnt(request).get(0);
			_status="success";
			_message="selectFollowerCnt("+request+") success\n";
		}catch (Exception e) {
			_status="error";
			_message="selectFollowerCnt("+request+") error\n";
		}
		AjaxResponse result=new AjaxRestResponse().builder().count(_count).status(_status).message(_message).build(); 
		return result;
	}
	
	/*팔로이 갯수
	 * request{userId}
	 * */
	public AjaxResponse selectFolloweeCnt(Map request) {
		int _count=0;
		String _status="";
		String _message="";
		try {
			_count=dao.selectFollowerCnt(request).get(0);
			_status="success";
			_message="selectFolloweeCnt("+request+") success\n";
		}catch (Exception e) {
			_status="error";
			_message="selectFolloweeCnt("+request+") error\n";
		}
		AjaxResponse result=new AjaxRestResponse().builder().count(_count).status(_status).message(_message).build(); 
		return result;
	}
	
	/*팔로워 확인 
	 * request{	userId }
	 * */
	public AjaxResponse selectFollower(Map request) {
		String _status="";
		String _message="";
		Object _data="";	//nullPointerException 때문에 ""를 넣어둠..
		try {
			_data=dao.selectFollowerList(request);
			_status="success";
			_message="selectFollower("+request+") success\n";
		}catch (Exception e) {
			_status="error";
			_message="selectFollower("+request+") error\n";
		}
		AjaxResponse result=new AjaxRestResponse().builder().data(_data).status(_status).message(_message).build(); 
		return result;
	}
	
	/*팔로이 확인
	 * request{	userId }
	 * */
	public AjaxResponse selectFollowee(Map request) {
		String _status="";
		String _message="";
		Object _data="";	//nullPointerException 때문에 ""를 넣어둠..
		try {
			_data=dao.selectFolloweeList(request);
			_status="success";
			_message="selectFollowee("+request+") success\n";
		}catch (Exception e) {
			_status="error";
			_message="selectFollowee("+request+") error\n";
		}
		AjaxResponse result=new AjaxRestResponse().builder().data(_data).status(_status).message(_message).build(); 
		return result;
	}
	
	
	
	/*팔로우 신청
	 * request{
	 * 	userId
	 * 	followerId
	 * }
	 * */
	public AjaxResponse insertFollower(Map request) {
		int _count=0;	
		String _status="";
		String _message="";
		try {
			_count=dao.insertFollower(request);
			if(_count!=1) throw new Exception();
			_status="success";
			_message="insertFollower("+request+") success\n";
		}catch (Exception e) {
			_count=0;
			_status="error";
			_message="insertFollower("+request+") error\n";
		}
		AjaxResponse result=new AjaxRestResponse().builder().count(_count).status(_status).message(_message).build(); 
		return result;
	}
	
	/*팔로이 신청 수락
	 * request{
	 * 	userId
	 * 	followeeId
	 * }
	 * */
	//테이블이 어떻게 구현되있는 확인 필요 (컨펌 필요)
	public AjaxResponse acceptFollwee(Map request) {
		return null;
	}
	
	/*팔로우 취소(팔로워 삭제)
	 * request{
	 * 	userId
	 * 	followerId
	 * }
	 * */
	public AjaxResponse deleteFollower(Map request) {
		int _count=0;	
		String _status="";
		String _message="";
		try {
			_count=dao.deleteFollower(request);
			if(_count!=1) throw new Exception();
			_status="success";
			_message="deleteFollower("+request+") success\n";
		}catch (Exception e) {
			_count=0;
			_status="error";
			_message="deleteFollower("+request+") error\n";
		}
		AjaxResponse result=new AjaxRestResponse().builder().count(_count).status(_status).message(_message).build(); 
		return result;
	}
	
	/*팔로이 삭제하기(팔로우 취소시키기)
	 * request{
	 * 	userId
	 * 	followeeId
	 * }
	 * */
	public AjaxResponse deleteFollowee(Map request) {
		int _count=0;	
		String _status="";
		String _message="";
		try {
			_count=dao.deleteFollowee(request);
			if(_count!=1) throw new Exception();
			_status="success";
			_message="deleteFollowee("+request+") success\n";
		}catch (Exception e) {
			_count=0;
			_status="error";
			_message="deleteFollowee("+request+") error\n";
		}
		AjaxResponse result=new AjaxRestResponse().builder().count(_count).status(_status).message(_message).build(); 
		return result;
	}
}
