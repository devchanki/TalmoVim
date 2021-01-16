package com.talmo.vim.follow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talmo.vim.follow.util.abstractObj.FollowServiceTemplate;
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
 * one
 * list
 * 
 * */

@Service
public class FollowService {
	@Autowired
	FollowRepository dao;	
	
	/*==================기본 서비스==================*/
	// 템플릿 메소드 패턴 + 빌더+팩토리 패턴
	
	/*이너 객체 목록*/
	private SelectFollowerCntService selectFollowerCntService;
	private SelectFolloweeCntService selectFolloweeCntService;
	private SelectFollowerService selectFollowerService;
	private SelectFolloweeService selectFolloweeService;
	private DeleteFollowerService deleteFollowerService;
	private DeleteFolloweeService deleteFolloweeService;
	private InsertFolloweeService InsertFolloweeService;
	
	/*기본 생성자*/
	public FollowService() {
		selectFollowerCntService=new SelectFollowerCntService();
		selectFolloweeCntService=new SelectFolloweeCntService();
	}
	
	/*팔로워 갯수
	 * request{userId}
	 * */
	public AjaxResponse selectFollowerCnt(Map request) {
		AjaxResponse result=selectFollowerCntService.proceed(request);
		return result;
	}
	
	/*팔로이 갯수
	 * request{userId}
	 * */
	public AjaxResponse selectFolloweeCnt(Map request) {
		AjaxResponse result=selectFolloweeCntService.proceed(request);
		return result;
	}
	
	/*팔로워 확인 
	 * request{	userId }
	 * */
	public AjaxResponse selectFollower(Map request) {
		AjaxResponse result=selectFollowerService.proceed(request); 
		return result;
	}
	
	/*팔로이 확인
	 * request{	userId }
	 * */
	public AjaxResponse selectFollowee(Map request) {
		AjaxResponse result=selectFolloweeService.proceed(request); 
		return result;
	}
	
	/*팔로우 신청
	 * request{
	 * 	userId
	 * 	followerId
	 * }
	 * */
	public AjaxResponse insertFollower(Map request) {
		AjaxResponse result=InsertFolloweeService.proceed(request); 
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
		//todo
		return null;
	}
	
	/*팔로우 취소(팔로워 삭제)
	 * request{
	 * 	userId
	 * 	followerId
	 * }
	 * */
	public AjaxResponse deleteFollower(Map request) {
		AjaxResponse result=deleteFollowerService.proceed(request); 
		return result;
	}
	
	/*팔로이 삭제하기(팔로우 취소시키기)
	 * request{
	 * 	userId
	 * 	followeeId
	 * }
	 * */
	public AjaxResponse deleteFollowee(Map request) {
		AjaxResponse result=deleteFolloweeService.proceed(request); 
		return result;
	}
	
	/*==================복합 서비스==================*/
	
	/*팔로우 명수 초기화 : 팔로워 명수, 팔로이 명수
	 * request{userId}
	 * */
	public AjaxResponse initFollowCnt(Map request) {
		Map _data = new HashMap<String, Object>();
		//팔로우 갯수, 팔로이 갯수 함수 호출
		_data.put("follower_cnt", ((AjaxRestResponse)selectFollowerCntService.proceed(request)).getData());
		_data.put("followee_cnt", selectFolloweeCntService.proceed(request));
		
		AjaxResponse result=new AjaxRestResponse();
		return null;
	}
	
	/*팔로워 체크 : 팔로워 명수, 팔로워 리스트
	 * request{userId}
	 * */
	public AjaxResponse initFollowerList(Map request) {
		//팔로워 명수, 팔로워 리스트 함수 호출
		return null;
	}
	
	/*팔로이 체크 : 팔로이 명수, 팔로이 리스트
	 * request{userId}
	 * */
	public AjaxResponse initFolloweeList(Map request) {
		//팔로이 명수, 팔로이 리스트 함수 호출
		return null;
	}
	
	/*상대 팔로우 체크 : 상대와 나와의 팔로워, 팔로이 관계 확인*/
	public AjaxResponse chkFollow(Map request) {
		//확인 함수 호출
		return null;
	}
	
	
	/*==================서비스 메소드 구현==================*/
	/*팔로워 갯수*/
	class SelectFollowerCntService extends FollowServiceTemplate{		
		protected void setDataFromDB() throws Exception{
			_count=dao.selectFollowerCnt(request).get(0);
		}
		protected void setMessageSuccess() {
			_message="selectFollowerCnt("+request+") success\n";
		}
		protected void setMessageError() {
			_message="selectFollowerCnt("+request+") error\n";
		}
		protected AjaxResponse makeAjaxResponse() {
			AjaxResponse result=new AjaxRestResponse().builder().count(_count).status(_status).message(_message).build(); 
			return result;
		}
	}
	
	/*팔로이 갯수*/
	class SelectFolloweeCntService extends FollowServiceTemplate{
		protected void setDataFromDB() throws Exception{
			_count=dao.selectFolloweeCnt(request).get(0);
		}
		protected void setMessageSuccess() {
			_message="selectFolloweeCnt("+request+") success\n";
		}
		protected void setMessageError() {
			_message="selectFolloweeCnt("+request+") error\n";
		}
		protected AjaxResponse makeAjaxResponse() {
			AjaxResponse result=new AjaxRestResponse().builder().count(_count).status(_status).message(_message).build(); 
			return result;
		}
	}
	
	/*팔로워 확인 */
	class SelectFollowerService extends FollowServiceTemplate{
		protected void setDataFromDB() throws Exception{
			_data=dao.selectFollowerList(request);		
		}
		protected void setMessageSuccess() {
			_message="selectFollower("+request+") success\n";
		}
		protected void setMessageError() {
			_message="selectFollower("+request+") error\n";
		}
		protected AjaxResponse makeAjaxResponse() {
			AjaxResponse result=new AjaxRestResponse().builder().data(_data).status(_status).message(_message).build(); 
			return result;
		}
	}
	
	/*팔로이 확인 */
	class SelectFolloweeService extends FollowServiceTemplate{
		protected void setDataFromDB() throws Exception{
			_data=dao.selectFolloweeList(request);		
		}
		protected void setMessageSuccess() {
			_message="selectFollowee("+request+") success\n";
		}
		protected void setMessageError() {
			_message="selectFollowee("+request+") error\n";
		}
		protected AjaxResponse makeAjaxResponse() {
			AjaxResponse result=new AjaxRestResponse().builder().data(_data).status(_status).message(_message).build(); 
			return result;
		}
	}
	
	/*팔로우 취소(팔로워 삭제)*/
	class DeleteFollowerService extends FollowServiceTemplate{
		protected void setDataFromDB() throws Exception {
			_count=dao.deleteFollower(request);
			if(_count!=1) throw new Exception();
		}
		protected void setMessageSuccess() {
			_message="deleteFollower("+request+") success\n";
		}
		protected void setMessageError() {
			_message="deleteFollower("+request+") error\n";
		}
		protected AjaxResponse makeAjaxResponse() {
			AjaxResponse result=new AjaxRestResponse().builder().count(_count).status(_status).message(_message).build(); 
			return result;
		}
	}
	
	/*팔로이 삭제*/
	class DeleteFolloweeService extends FollowServiceTemplate{
		protected void setDataFromDB() throws Exception{
			_count=dao.deleteFollowee(request);
			if(_count!=1) throw new Exception();
		}
		protected void setMessageSuccess() {
			_message="deleteFollowee("+request+") success\n";
		}
		protected void setMessageError() {
			_message="deleteFollowee("+request+") error\n";
		}
		protected AjaxResponse makeAjaxResponse() {
			AjaxResponse result=new AjaxRestResponse().builder().count(_count).status(_status).message(_message).build(); 
			return result;
		}
	}
	
	/*팔로이 추가*/
	class InsertFolloweeService extends FollowServiceTemplate{
		protected void setDataFromDB() throws Exception{
			_count=dao.insertFollowee(request);
			if(_count!=1) throw new Exception();
		}
		protected void setMessageSuccess() {
			_message="insertFollowee("+request+") success\n";
		}
		protected void setMessageError() {
			_message="insertFollowee("+request+") error\n";
		}
		protected AjaxResponse makeAjaxResponse() {
			AjaxResponse result=new AjaxRestResponse().builder().count(_count).status(_status).message(_message).build(); 
			return result;
		}
	}
}
