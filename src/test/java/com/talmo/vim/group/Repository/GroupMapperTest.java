package com.talmo.vim.group.Repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.talmo.vim.group.GroupMapper;
import com.talmo.vim.group.dto.GroupVO;

import lombok.extern.slf4j.Slf4j;
import java.util.*;

@Slf4j
@SpringBootTest
public class GroupMapperTest {
	@Autowired
    GroupMapper mapper;
	
	private static List<GroupVO> voList;
	
	@BeforeAll
	public static void setTestVo(@Autowired GroupMapper repo) {
		voList = new ArrayList<>();
		voList.add( GroupVO.builder().groupName("testgroup1").userId(1000L).groupDesc("testdesc1").build() );
		voList.add( GroupVO.builder().groupName("testgroup2").userId(1000L).groupDesc("testdesc2").build() );
		voList.add( GroupVO.builder().groupName("testgroup3").userId(2000L).groupDesc("testdesc3").build() );
		
		for(GroupVO vo : voList) {
			long rstCount = repo.insertGroup(vo); 
			assertThat(rstCount).isNotEqualTo(0L);
		}
		
		log.info("Succes to insert all test_group!" );
	}
	
	@AfterAll
	public static void deleteAll(@Autowired GroupMapper repo) {
		for(GroupVO vo : voList) {
			
			long rstCount = repo.deleteGroup(vo.getGroupId());
			assertThat(rstCount).isNotEqualTo(0L);
		}

		log.info("Succes to remove all test_group!");
	}
	
	@Test
	public void createAndDeleteGroupTest() {
		String groupName = "TestGroupName";
		Long createUserId = 1000L;
		String groupDese = "this is TestGroup";
		
		//Create Test
		GroupVO vo = GroupVO.builder().groupName(groupName).userId(createUserId).groupDesc(groupDese).build();
		long rstCount = mapper.insertGroup(vo);
		
		assertThat(rstCount).isNotEqualTo(0L);
		log.info("Succes to Create test_group! => id: " + vo.getGroupId() );
		
		//Delete Test
		log.debug("delete Group info => id: " + vo.getGroupId() + " userid: " + vo.getUserId());
		rstCount = mapper.deleteGroup(vo.getGroupId());
		
		assertThat(rstCount).isNotEqualTo(0L);
		log.info("Succes to remove test_group! => id: " + vo.getGroupId() );
	}
	
	@Test
	public void getGroupInfoTest() {
		for(GroupVO vo : voList) {
			GroupVO rst = mapper.selectGroup(vo.getGroupId());
			checkGroup(vo, rst);
		}
		log.info("Succes to get test_group!");;
	}
	
	public void checkGroup(GroupVO g1, GroupVO g2) {
		assertThat(g1.getGroupId()).isEqualTo(g2.getGroupId());
		assertThat(g1.getGroupName()).isEqualTo(g2.getGroupName());
		assertThat(g1.getGroupDesc()).isEqualTo(g2.getGroupDesc());
		assertThat(g1.getUserId()).isEqualTo(g2.getUserId());
	}
	
	@Test
	public void updateGroupInfoTest() {
		
	}
}
