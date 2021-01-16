package com.talmo.vim.follow.util.abstractObj;

import java.util.Map;

import com.talmo.vim.follow.util.response.AjaxResponse;

public abstract class FollowServiceTemplate {
	protected int _count=0;
	protected String _status="";
	protected String _message="";
	protected Object _data="";
	protected Map<String, Object> request;
	
	public AjaxResponse proceed(Map<String, Object> request) {
		try {
			this.request=request;
			setDataFromDB();
			_status="success";
			setMessageSuccess();
		}catch(Exception e){
			_status="error";
			setMessageError();
		}
		return makeAjaxResponse();
	}
	
	abstract protected void setDataFromDB() throws Exception;
	abstract protected void setMessageSuccess();
	abstract protected void setMessageError();
	abstract protected AjaxResponse makeAjaxResponse();
}
