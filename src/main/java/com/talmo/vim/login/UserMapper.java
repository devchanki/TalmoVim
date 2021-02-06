package com.talmo.vim.login;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
	int insertSNSMember(HashMap param);
}
