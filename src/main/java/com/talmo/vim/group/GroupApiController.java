package com.talmo.vim.group;

import com.talmo.vim.common.ResponseDto;
import com.talmo.vim.common.ResponseStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@Slf4j
@RestController
@RequestMapping("/group/api/")
public class GroupApiController {
	
	@Autowired
	GroupService service;

	@PostMapping("/new")
	public ResponseDto createGroupRequest(@RequestBody Map<String, Object> map) {
		//TODO : (KHJ) 로그인 유저 확인 세션 필요
		log.debug("New param : " + map);

		ResponseDto response = new ResponseDto();
		response.setStatus(ResponseStatus.NOT_IMPLEMENTED);
		response.setMessage("send test");
		Object rst = null;
		response.setData(map);
		return response;
	}
}
