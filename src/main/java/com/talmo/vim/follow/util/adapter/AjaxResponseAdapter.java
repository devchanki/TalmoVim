package com.talmo.vim.follow.util.adapter;

import com.talmo.vim.follow.util.response.AjaxResponse;

public abstract class AjaxResponseAdapter implements AjaxResponse {
	
	public AjaxResponseAdapter(Object adaptee) {
		transform(adaptee);
	}
	
	protected abstract void transform(Object adaptee);
}
