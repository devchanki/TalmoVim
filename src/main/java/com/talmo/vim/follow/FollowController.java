package com.talmo.vim.follow;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talmo.vim.follow.util.response.AjaxResponse;


@RestController
@RequestMapping("/follow")
public class FollowController {
	@Autowired
	private FollowService followService;
	
	private AjaxResponse ajaxResponse;
	
	/*팔로우 팔로이 단일 대상 확인*/
	@PostMapping("/one")
	public AjaxResponse chkFollow(@RequestBody Map<String, Object> request) {
		
		ajaxResponse=followService.chkFollow(request);
		return ajaxResponse;
	}
	
	/*팔로우 카운트 초기화*/
	@PostMapping("/my")
	public AjaxResponse initFollow(@RequestBody Map<String, Object> request) {
		
		ajaxResponse=followService.chkFollow(request);
		return ajaxResponse;
	}
	
	/*팔로워 리스트 초기화*/
	@PostMapping("/follower")
	public AjaxResponse initFollowerList(@RequestBody Map<String, Object> request) {
		
		ajaxResponse=followService.initFollowerList(request);
		return ajaxResponse;
	}
	
	/*팔로이 리스트 초기화*/
	@PostMapping("/followee")
	public AjaxResponse initFolloweeList(@RequestBody Map<String, Object> request) {
		
		ajaxResponse=followService.initFolloweeList(request);
		return ajaxResponse;
	}
	
	/*팔로워 제거*/
	@DeleteMapping("/followee")
	public AjaxResponse deleteFollower(@RequestBody Map<String, Object> request) {
		
		ajaxResponse=followService.chkFollow(request);
		return ajaxResponse;
	}
	
	/*팔로워 제거*/
	@DeleteMapping("/follower")
	public AjaxResponse deleteFollowee(@RequestBody Map<String, Object> request) {
		
		ajaxResponse=followService.chkFollow(request);
		return ajaxResponse;
	}
	
	/*팔로이 추가(팔로우 하기)*/
	@PutMapping("/followee")
	public AjaxResponse addFollowee(@RequestBody Map<String, Object> request) {
		
		ajaxResponse=followService.chkFollow(request);
		return ajaxResponse;
	}
	
	
}
