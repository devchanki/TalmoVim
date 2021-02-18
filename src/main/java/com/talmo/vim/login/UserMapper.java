package com.talmo.vim.login;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
	int insertTalmoMember(HashMap param);
	
	HashMap getTalmoInfo(HashMap param);
	
	int insertSNSMember(HashMap param);
	
	HashMap getSNSInfo(HashMap param);
}
