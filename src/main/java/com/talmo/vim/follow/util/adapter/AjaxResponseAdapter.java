package com.talmo.vim.follow.util.adapter;

import com.talmo.vim.follow.util.response.AjaxResponse;

public abstract class AjaxResponseAdapter extends AjaxResponse {
	
	public AjaxResponseAdapter(Object adaptee) {
		transform(adaptee);
	}
	
	protected abstract void transform(Object adaptee);
}
