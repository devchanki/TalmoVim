package com.talmo.vim.follow;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talmo.vim.follow.util.dto.ResultDTO;
import com.talmo.vim.follow.util.serviceTemplate.FollowComplexServiceTemplate;

@Service
public class FollowComplexService{
	@Autowired
	private FollowBasicService followBasicService;
	
	/*==================서비스 메소드==================*/
	// 템플릿 메소드 패턴 + 빌더+팩토리 패턴
	
	/*이너 객체 목록*/
	private InitFollowCntService initFollowCntService;
	private InitFollowerListService initFollowerListService;
	private InitFolloweeListService initFolloweeListService;
	private ChkFollowService chkFollowService;
	
	/*기본 생성자*/
	public FollowComplexService() {
		initFollowCntService=new InitFollowCntService();
		initFollowerListService=new InitFollowerListService();
		initFolloweeListService=new InitFolloweeListService();
		chkFollowService=new ChkFollowService();
	}
	
	/*팔로우 명수 초기화 : 팔로워 명수, 팔로이 명수
	 * request{userId}
	 * */
	public ResultDTO initFollowCnt(Map request) {
		ResultDTO result = initFollowCntService.proceed(request);
		return result;
	}
	
	/*팔로워 체크 : 팔로워 명수, 팔로워 리스트
	 * request{userId}
	 * */
	public ResultDTO initFollowerList(Map request) {
		ResultDTO result = initFollowerListService.proceed(request);		
		return result;
	}
	
	/*팔로이 체크 : 팔로이 명수, 팔로이 리스트
	 * request{userId}
	 * */
	public ResultDTO initFolloweeList(Map request) {
		ResultDTO result = initFolloweeListService.proceed(request);
		return result;
	}
	
	/*상대 팔로우 체크 : 상대와 나와의 팔로워, 팔로이 관계 확인*/
	public ResultDTO chkFollow(Map request) {
		ResultDTO result = chkFollowService.proceed(request);
		return null;
	}
	
	/*==================서비스 메소드 구현 내부 클래스==================*/
	/*팔로우 명수 초기화 : 팔로워 명수, 팔로이 명수*/
	class InitFollowCntService extends FollowComplexServiceTemplate{
		@Override
		protected void complexServiceLogic() throws Exception {
			Map map = new HashMap<String, Object>();
			//팔로우 수 호출
			result=followBasicService.selectFollowerCnt(request);
			_message+=result.getMessage()+", ";
			if(!(result.getStatus().equals("success"))) throw new Exception();
			map.put("follower_cnt", result.getCount());
			
			//팔로이 수 호출
			result=followBasicService.selectFolloweeCnt(request);
			_message+=result.getMessage();
			if(!(result.getStatus().equals("success"))) throw new Exception();
			map.put("followee_cnt", result.getCount());
			
			_count=1;
			_data=map;
		}
		@Override
		protected void setMessageFinally() {
			_message="["+_status+"]initFollowCnt("+request+"){ "+_message+" }";
		}
	}
	
	/*팔로워 체크 : 팔로워 수, 팔로워 리스트*/
	class InitFollowerListService extends FollowComplexServiceTemplate{
		@Override
		protected void complexServiceLogic() throws Exception {
			_data = new HashMap<String, Object>();
			//팔로워 수
			result=followBasicService.selectFollowerCnt(request);
			_message+=result.getMessage()+", ";
			if(!(result.getStatus().equals("success"))) throw new Exception();
			_count=result.getCount();
			
			//팔로워 리스트
			result=followBasicService.selectFollower(request);
			_message+=result.getMessage();
			if(!(result.getStatus().equals("success"))) throw new Exception();
			_data=result.getData();
		}
		@Override
		protected void setMessageFinally() {
			_message="["+_status+"]initFollowerList("+request+"){ "+_message+" }";
		}
	}
	
	/*팔로이 체크 : 팔로이 수, 팔로이 리스트*/
	class InitFolloweeListService extends FollowComplexServiceTemplate{
		@Override
		protected void complexServiceLogic() throws Exception {
			_data = new HashMap<String, Object>();
			//팔로이 수
			result=followBasicService.selectFolloweeCnt(request);
			_message+=result.getMessage()+", ";
			if(!(result.getStatus().equals("success"))) throw new Exception();
			_count=result.getCount();
			
			//팔로이 리스트
			result=followBasicService.selectFollowee(request);
			_message+=result.getMessage();
			if(!(result.getStatus().equals("success"))) throw new Exception();
			_data=result.getData();
		}
		@Override
		protected void setMessageFinally() {
			_message="["+_status+"]initFolloweeList("+request+"){ "+_message+" }";
		}
	}
	
	/*상대 팔로우 체크 : 상대와 나의 팔로워 팔로이 여부 체크*/
	class ChkFollowService extends FollowComplexServiceTemplate{
		@Override
		protected void complexServiceLogic() throws Exception {
			Map map = new HashMap<String, Object>();
			//팔로워 체크
			result=followBasicService.selectFollower(request);
			_message+=result.getMessage()+", ";
			if(!(result.getStatus().equals("success"))) throw new Exception();
			if(result.getData()!=null)
				map.put("is_follower", 1);
			else
				map.put("is_follower", 0);
			
			//팔로이 체크
			result=followBasicService.selectFolloweeCnt(request);
			_message+=result.getMessage();
			if(!(result.getStatus().equals("success"))) throw new Exception();
			if(result.getData()!=null)
				map.put("is_followee", 1);
			else
				map.put("is_followee", 0);
			
			_count=1;
			_data=map;
		}
		@Override
		protected void setMessageFinally() {
			_message="["+_status+"]initFolloweeList("+request+"){ "+_message+" }";
		}
	}
}
