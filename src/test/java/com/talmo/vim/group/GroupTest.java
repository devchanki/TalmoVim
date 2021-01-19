package com.talmo.vim.group;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import group.GroupRepository;

@SpringBootTest (properties = "classpath:application-test.properties")
public class GroupTest {
	@Autowired
	GroupRepository repo;
	
	@Test
	public void createGroupTest() {
		
	}
}
