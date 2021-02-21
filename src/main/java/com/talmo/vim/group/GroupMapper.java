package com.talmo.vim.group;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.talmo.vim.group.dto.GroupVO;

@Repository @Mapper
public interface GroupMapper {
	public long insertGroup(GroupVO vo);

	public long deleteGroup(long groupId);

	public GroupVO selectGroup(long groupId);
}
