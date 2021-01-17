package com.talmo.vim.follow.util.serviceTemplate;

import java.util.Map;

import com.talmo.vim.follow.util.dto.FollowResultDTO;
import com.talmo.vim.follow.util.dto.ResultDTO;

public abstract class FollowComplexServiceTemplate {
	protected ResultDTO result;
	protected Map<String, Object> request;

	protected int _count=0;
	protected String _status="";
	protected String _message="";
	protected Object _data;
	
	public final ResultDTO proceed(Map<String, Object> request) {
		this.request=request;
		try {
			complexServiceLogic();
			_status="success";
			setMessageSuccess();
		}catch(Exception e) {
			_status="error";
			setMessageError();
		}finally {
			_message="initFollowerList("+request+") "+_message; //다중 메세지 입력
			setMessageFinally();
		}
		
		result=new FollowResultDTO().builder().count(_count).data(_data).status(_status).message(_message).build();
		return result;
	}
	
	abstract protected void complexServiceLogic() throws Exception;
	protected void setMessageSuccess() {}
	protected void setMessageError() {}
	protected void setMessageFinally() {}
}
