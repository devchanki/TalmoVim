package com.talmo.vim.group;

import com.talmo.vim.group.dto.GroupDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class GroupService {
	@Autowired
	GroupRepository groupRepo;

	@Autowired
	GroupMapper groupMapper;

	@PersistenceContext
	EntityManager em;

	@Transactional
	public GroupDto.Response createNewGroup(Long userId, GroupDto.Create param) {
		//TODO: login session 체크 및 Memeber Entity 추가 (master 권한)
		//Long userid;
		Group group = param.toEntity();
		group = groupRepo.save(group);
		GroupDto.Response rst = new GroupDto.Response(group);

		return rst;
	}

	public GroupDto.Response findGroup( Long groupId) {
		Group group = groupRepo.findById(groupId).orElseThrow(EntityExistsException::new);

		GroupDto.Response rst = new GroupDto.Response(group);
		return rst;
	}

	public Group findGroups() {
		return null;
	}

	@Transactional
	public void deleteGroup(Group group) {
		groupRepo.delete(group);
	}

}
