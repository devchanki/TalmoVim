package com.talmo.vim.follow.util.adapter;

import com.talmo.vim.follow.util.dto.FollowResultDTO;

public class FollowAjaxRestResponseAdapter extends AjaxResponseAdapter {

	private int count;
	private String status;
	private String message;
	private Object data;
	
	public FollowAjaxRestResponseAdapter(Object adaptee) {
		super(adaptee);
	}

	@Override
	protected void transform(Object adaptee) {
		FollowResultDTO dto=(FollowResultDTO)adaptee;
		this.count=dto.getCount();
		this.status=dto.getStatus();
		this.message=dto.getMessage();
		this.data=dto.getData();
	}

}
