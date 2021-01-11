package com.talmo.vim.follow;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talmo.vim.follow.util.response.AjaxResponse;

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
	
	/*팔로워 갯수
	 * request{userId}
	 * */
	public AjaxResponse selectFollowerCnt(Map request) {
		dao.selectFollowerCnt(request);
		return null;
	}
	
	/*팔로이 갯수
	 * request{userId}
	 * */
	public AjaxResponse selectFolloweeCnt(Map request) {
		return null;
	}
	
	/*팔로워 확인 
	 * request{
	 * 	userId
	 * 	type : one, list
	 *  followerId : one일때 확인해주는 용도
	 * }
	 * */
	public AjaxResponse selectFollower(Map request) {
		return null;
	}
	
	/*팔로이 확인
	 * request{
	 * 	userId
	 * 	type : one, list
	 *	followeeId : one일때 확인해주는 용도
	 * }
	 * */
	public AjaxResponse selectFollowee(Map request) {
		return null;
	}
	
	/*팔로우 신청
	 * request{
	 * 	userId
	 * 	followerId
	 * }
	 * */
	public AjaxResponse insertFollower(Map request) {
		return null;
	}
	
	/*팔로이 신청 수락
	 * request{
	 * 	userId
	 * 	followeeId
	 * }
	 * */
	//테이블이 어떻게 구현되있는 확인 필요
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
		return null;
	}
	
	/*팔로이 삭제하기(팔로우 취소시키기)
	 * request{
	 * 	userId
	 * 	followeeId
	 * }
	 * */
	public AjaxResponse deleteFollowee(Map request) {
		return null;
	}
}
