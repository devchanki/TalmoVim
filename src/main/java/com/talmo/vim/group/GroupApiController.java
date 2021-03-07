package com.talmo.vim.group;

import com.talmo.vim.common.ResponseDto;
import com.talmo.vim.common.ResponseStatus;
import com.talmo.vim.group.dto.GroupDto;
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
	public ResponseDto createGroupRequest(@RequestBody GroupDto.Create param) {
		//TODO : (KHJ) 로그인 유저 확인 세션 필요
		Long userid = 0L;
		log.debug("New param : " + param);
		try{
			ResponseDto dto = ResponseDto.builder()
					.data( service.createNewGroup(userid, param) )
					.status(ResponseStatus.SUCCESS)
					.message("Success to signup")
					.build();
			return dto;
		} catch (IllegalArgumentException e) {
			return ResponseDto.builder()
					.data(null)
					.status(ResponseStatus.ILLEGAL_PARAMETER)
					.message("Parameter is not illegal")
					.build();
		} catch (Exception e) {
			return ResponseDto.builder()
					.status(ResponseStatus.FAIL)
					.message("Request Fail for other reason.\n" + e.getMessage())
					.build();
		}
	}
}
