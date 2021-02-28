package com.talmo.vim.group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Group createNewGroup(long userId, Group group ) {
		//TODO: check login session
		//Long userid;
		return groupRepo.save(group);
	}

	public Group findGroup() {
		return null;
	}

	public Group findGroups() {
		return null;
	}

	@Transactional
	public void deleteGroup(Group group) {
		groupRepo.delete(group);
	}

}
