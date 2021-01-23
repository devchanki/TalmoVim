package com.talmo.vim.follow.util.response;

import lombok.Data;

@Data
public abstract class AjaxResponse {
	protected int count;
	protected String status;
	protected String message;
	protected Object data;
}
