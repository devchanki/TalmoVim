package com.talmo.vim.follow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talmo.vim.follow.util.dto.FollowResultDTO;
import com.talmo.vim.follow.util.dto.ResultDTO;
import com.talmo.vim.follow.util.response.AjaxResponse;
import com.talmo.vim.follow.util.serviceTemplate.FollowBasicServiceTemplate;

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
public class FollowBasicService {
	@Autowired
	FollowRepository dao;

	// 템플릿 메소드 패턴 + 빌더+팩토리 패턴
	/* ==================서비스 메소드================== */

	/*
	 * 팔로워 갯수 request{user_id}
	 */
	public ResultDTO selectFollowerCnt(Map request) {
		ResultDTO result = new SelectFollowerCntService().proceed(request);
		return result;
	}

	/*
	 * 팔로이 갯수 request{user_id}
	 */
	public ResultDTO selectFolloweeCnt(Map request) {
		ResultDTO result = new SelectFolloweeCntService().proceed(request);
		return result;
	}

	/*
	 * 팔로워 리스트 request{ user_id , type : "default"} request{ user_id , type : "one"
	 * , opponent_id} request{ user_id , type : "list", row_cnt : 원하는 튜플 수, from_row
	 * : 시작 튜플 }
	 */
	public ResultDTO selectFollower(Map request) {
		ResultDTO result = new SelectFollowerService().proceed(request);
		return result;
	}

	/*
	 * 팔로이 리스트 request{ user_id , type : "default"} request{ user_id , type : "one"
	 * , opponent_id} request{ user_id , type : "list", row_cnt : 원하는 튜플 수, from_row
	 * : 시작 튜플 }
	 */
	public ResultDTO selectFollowee(Map request) {
		ResultDTO result = new SelectFolloweeService().proceed(request);
		return result;
	}

	/*
	 * 팔로우 신청 request{ user_id opponent_id }
	 */
	public ResultDTO insertFollowee(Map request) {
		ResultDTO result = new InsertFolloweeService().proceed(request);
		return result;
	}

	/*
	 * 팔로이 신청 수락 request{ user_id opponent_id }
	 */
	// 테이블이 어떻게 구현되있는 확인 필요 (컨펌 필요)

	/*
	 * 팔로우 취소(팔로워 삭제) request{ user_id opponent_id }
	 */
	public ResultDTO deleteFollower(Map request) {
		ResultDTO result = new DeleteFollowerService().proceed(request);
		return result;
	}

	/*
	 * 팔로이 삭제하기(팔로우 취소시키기) request{ user_id opponent_id }
	 */
	public ResultDTO deleteFollowee(Map request) {
		ResultDTO result = new DeleteFolloweeService().proceed(request);
		return result;
	}

	/* ==================서비스 메소드 구현 내부 클래스================== */
	/* 팔로워 갯수 */
	class SelectFollowerCntService extends FollowBasicServiceTemplate {
		@Override
		protected void setDataFromDB() throws Exception {
			_count = dao.selectFollowerCnt(request).get(0);
		}

		@Override
		protected void setMessageFinally() {
			_message = _status + ": SelectFollowerCntService";
		}

		@Override
		protected ResultDTO makeResultDTO() {
			ResultDTO result = new FollowResultDTO().builder().count(_count).status(_status).message(_message).build();
			return result;
		}
	}

	/* 팔로이 갯수 */
	class SelectFolloweeCntService extends FollowBasicServiceTemplate {
		@Override
		protected void setDataFromDB() throws Exception {
			_count = dao.selectFolloweeCnt(request).get(0);
		}

		@Override
		protected void setMessageFinally() {
			_message = _status + ": SelectFolloweeCntService";
		}

		@Override
		protected ResultDTO makeResultDTO() {
			ResultDTO result = new FollowResultDTO().builder().count(_count).status(_status).message(_message).build();
			return result;
		}
	}

	/* 팔로워 확인 */
	class SelectFollowerService extends FollowBasicServiceTemplate {
		@Override
		protected void setDataFromDB() throws Exception {
			_data = dao.selectFollowerList(request);
		}

		@Override
		protected void setMessageFinally() {
			_message = _status + ": SelectFollowerService";
		}

		@Override
		protected ResultDTO makeResultDTO() {
			ResultDTO result = new FollowResultDTO().builder().data(_data).status(_status).message(_message).build();
			return result;
		}
	}

	/* 팔로이 확인 */
	class SelectFolloweeService extends FollowBasicServiceTemplate {
		@Override
		protected void setDataFromDB() throws Exception {
			_data = dao.selectFolloweeList(request);
		}

		@Override
		protected void setMessageFinally() {
			_message = _status + ": SelectFolloweeService";
		}

		@Override
		protected ResultDTO makeResultDTO() {
			ResultDTO result = new FollowResultDTO().builder().data(_data).status(_status).message(_message).build();
			return result;
		}
	}

	/* 팔로우 취소(팔로워 삭제) */
	class DeleteFollowerService extends FollowBasicServiceTemplate {
		@Override
		protected void setDataFromDB() throws Exception {
			_count = dao.deleteFollower(request);
			if (_count != 1)
				throw new Exception();
		}

		@Override
		protected void setMessageFinally() {
			_message = _status + ": DeleteFollowerService";
		}

		@Override
		protected ResultDTO makeResultDTO() {
			ResultDTO result = new FollowResultDTO().builder().count(_count).status(_status).message(_message).build();
			return result;
		}
	}

	/* 팔로이 삭제 */
	class DeleteFolloweeService extends FollowBasicServiceTemplate {
		@Override
		protected void setDataFromDB() throws Exception {
			_count = dao.deleteFollowee(request);
			if (_count != 1)
				throw new Exception();
		}

		@Override
		protected void setMessageFinally() {
			_message = _status + ": DeleteFolloweeService";
		}

		@Override
		protected ResultDTO makeResultDTO() {
			ResultDTO result = new FollowResultDTO().builder().count(_count).status(_status).message(_message).build();
			return result;
		}
	}

	/* 팔로이 추가 */
	class InsertFolloweeService extends FollowBasicServiceTemplate {
		@Override
		protected void setDataFromDB() throws Exception {
			_count = dao.insertFollowee(request);
			if (_count != 1)
				throw new Exception();
		}

		@Override
		protected void setMessageFinally() {
			_message = _status + ": InsertFolloweeService";
		}

		@Override
		protected ResultDTO makeResultDTO() {
			ResultDTO result = new FollowResultDTO().builder().count(_count).status(_status).message(_message).build();
			return result;
		}
	}
}
