package com.talmo.vim.follow;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talmo.vim.follow.util.dto.ResultDTO;
import com.talmo.vim.follow.util.response.AjaxResponse;
import com.talmo.vim.follow.util.response.FollowAjaxRestResponse;


@RestController
@RequestMapping("/follow")
public class FollowController {
	@Autowired
	private FollowBasicService followBasicService;
	@Autowired
	private FollowComplexService followComplexService;
	private AjaxResponse ajaxResponse;
	
	/*팔로우 팔로이 단일 대상 확인*/
	@PostMapping("/one")
	public AjaxResponse chkFollow(@RequestBody HashMap<String, Object> request) {
		ResultDTO result=followComplexService.chkFollow(request);
		AjaxResponse ajaxResponse = new FollowAjaxRestResponse();//todo builder
		return ajaxResponse;
	}
	
	/*팔로우 카운트 초기화*/
	@PostMapping("/my")
	public AjaxResponse initFollow(@RequestBody HashMap<String, Object> request) {
		ResultDTO result=followComplexService.initFollowCnt(request);
		AjaxResponse ajaxResponse = new FollowAjaxRestResponse();//todo builder
		return ajaxResponse;
	}
	
	/*팔로워 리스트 초기화*/
	@PostMapping("/follower")
	public AjaxResponse initFollowerList(@RequestBody HashMap<String, Object> request) {
		ResultDTO result=followComplexService.initFollowerList(request);
		AjaxResponse ajaxResponse = new FollowAjaxRestResponse();//todo builder
		return ajaxResponse;
	}
	
	/*팔로이 리스트 초기화*/
	@PostMapping("/followee")
	public AjaxResponse initFolloweeList(@RequestBody HashMap<String, Object> request) {
		ResultDTO result=followComplexService.initFolloweeList(request);
		AjaxResponse ajaxResponse = new FollowAjaxRestResponse();//todo builder
		return ajaxResponse;
	}
	
	/*팔로워 제거*/
	@DeleteMapping("/follower")
	public AjaxResponse deleteFollower(@RequestBody HashMap<String, Object> request) {
		ResultDTO result=followBasicService.deleteFollower(request);
		AjaxResponse ajaxResponse = new FollowAjaxRestResponse();//todo builder
		return ajaxResponse;
	}
	
	/*팔로워 제거*/
	@DeleteMapping("/followee")
	public AjaxResponse deleteFollowee(@RequestBody HashMap<String, Object> request) {
		ResultDTO result=followBasicService.deleteFollowee(request);
		AjaxResponse ajaxResponse = new FollowAjaxRestResponse();//todo builder
		return ajaxResponse;
	}
	
	/*팔로이 추가(팔로우 하기)*/
	@PutMapping("/followee")
	public AjaxResponse addFollowee(@RequestBody HashMap<String, Object> request) {
		ResultDTO result=followBasicService.insertFollowee(request);
		AjaxResponse ajaxResponse = new FollowAjaxRestResponse();//todo builder
		return ajaxResponse;
	}
	
	
}
