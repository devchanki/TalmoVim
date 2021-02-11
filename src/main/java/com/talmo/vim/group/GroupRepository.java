package com.talmo.vim.group;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.talmo.vim.group.util.GroupVO;
import java.util.*;

@Repository @Mapper
public interface GroupRepository {
	public long insertGroup(GroupVO vo);

	public long deleteGroup(long groupId);
	
	public GroupVO selectGroup(long groupId);
}
