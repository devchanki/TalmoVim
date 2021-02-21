package com.talmo.vim.login;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserVO {
	int code;
	String email;
	String user_role;
	String name;
	String nick;
	String gender;
	String tel1;
	String tel2;
	String tel3;
	String zipcode;
	String addr1;
	String addr2;
	int level;
	int point;
	String di;
	Date insert_dt;
	Date update_dt;
	String status;
	Date last_login;
	String session_id;
	Date session_expire;
}
