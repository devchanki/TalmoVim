package com.talmo.vim.follow.util.serviceTemplate;

import java.util.Map;

import com.talmo.vim.follow.util.dto.ResultDTO;

public abstract class FollowBasicServiceTemplate {
	protected int _count=0;
	protected String _status="";
	protected String _message="";
	protected Object _data="";
	protected Map<String, Object> request;
	
	public final ResultDTO proceed(Map<String, Object> request) {
		this.request=request;
		try {
			setDataFromDB();
			_status="success";
			setMessageSuccess();
		}catch(Exception e){
			_status="error";
			setMessageError();
			System.out.println(e.getMessage());
		}finally {
			setMessageFinally();
		}
		return makeResultDTO();
	}
	
	abstract protected void setDataFromDB() throws Exception;
	protected void setMessageSuccess() {}
	protected void setMessageError() {}
	protected void setMessageFinally() {}
	abstract protected ResultDTO makeResultDTO();
}
