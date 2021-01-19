package com.talmo.vim.group.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @Builder
public class GroupVO {
	private long groupId;
	private long userId;
	private String groupName;
	private String groupDesc;
}
