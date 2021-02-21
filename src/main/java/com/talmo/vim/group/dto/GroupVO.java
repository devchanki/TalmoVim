package com.talmo.vim.group.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @NoArgsConstructor
public class GroupVO {
	private long groupId;
	private long userId;
	private String groupName;
	private String groupDesc;

	@Builder
	public GroupVO(long groupId, long userId, String groupName, String groupDesc) {
		this.groupId = groupId;
		this.userId = userId;
		this.groupName = groupName;
		this.groupDesc = groupDesc;
	}
}
