package com.talmo.vim.group.util.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ResultDto {
	private String requset;
	private int status;
	private Object data;
}
