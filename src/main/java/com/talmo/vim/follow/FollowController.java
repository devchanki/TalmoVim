package com.talmo.vim.follow;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talmo.vim.follow.util.response.AjaxResponse;

@RestController
@RequestMapping("/follow")
public class FollowController {
	@Autowired
	private FollowService followService;
	
	private AjaxResponse ajaxResponse;
	
	/*팔로우 확인*/
	@GetMapping("")
	public AjaxResponse chkFollow() {
		Map<String, Object> request=new HashMap();
		
		ajaxResponse=followService.chkFollow(request);
		return ajaxResponse;
	}
	
	/**/
	
	
}
