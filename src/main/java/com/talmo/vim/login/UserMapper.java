package com.talmo.vim.login;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
	int insertTalmoMember(HashMap param);
	
	UserVO getTalmoInfo(HashMap param);
	
	UserVO getTalmoInfoByCode(HashMap param);
	
	int insertSNSMember(HashMap param);
	
	HashMap<String, String> getSNSInfo(HashMap<String, String> param);
}