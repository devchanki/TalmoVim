package com.talmo.vim.login;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserVO {
	int user_id;
	String user_email;
	String user_role;
	String user_name;
	String user_nick;
	String user_gender;
	String user_tel1;
	String user_tel2;
	String user_tel3;
	String user_zipcode;
	String user_addr1;
	String user_addr2;
	int user_level;
	int user_point;
	String user_di;
	Date user_insert_dt;
	Date user_update_dt;
	String user_status;
	Date user_last_login_dt;
	String user_session_id;
	Date user_session_expire_dt;
}
