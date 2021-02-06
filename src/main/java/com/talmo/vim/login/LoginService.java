package com.talmo.vim.login;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginService {
	
	
	@Autowired
	private UserMapper userMapper;
	
	@Transactional(rollbackFor = Exception.class)
	public int insertSNSMember(HashMap param) throws Exception{
		int result = 0;
		
		try {
			result = userMapper.insertSNSMember(param);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
