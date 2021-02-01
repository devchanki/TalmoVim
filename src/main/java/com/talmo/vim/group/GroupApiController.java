package com.talmo.vim.group;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/group/api/")
public class GroupApiController {
	
	@Autowired
	GroupService service;
	
	public Map<String, Object> createGroupRequest(@RequestBody String data) {		
		//TODO : (KHJ) 로그인 유저 확인 세션 필요
		
 		Map<String, Object> result = null;
		return result;
	}
}
