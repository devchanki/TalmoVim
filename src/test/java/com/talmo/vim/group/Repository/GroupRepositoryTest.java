//package com.talmo.vim.group.Repository;
//
//import com.talmo.vim.group.Group;
//import com.talmo.vim.group.GroupRepository;
//import com.talmo.vim.group.dto.GroupVO;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@Slf4j
//public class GroupRepositoryTest {
//
//    @Autowired
//    GroupRepository repo;
//
//    private static List<Group> groupList;
//
//    @BeforeAll
//    public static void setTestVo(@Autowired GroupRepository repo) {
//        groupList = new ArrayList<>();
//        groupList.add( Group.builder().name("testgroup1").owner(1000L).desc("testdesc1").build() );
//        groupList.add( Group.builder().name("testgroup2").owner(1000L).desc("testdesc2").build() );
//        groupList.add( Group.builder().name("testgroup3").owner(2000L).desc("testdesc3").build() );
//
//        for( int i = 0; i < groupList.size(); i++) {
//            Group group = repo.save(groupList.get(i));
//            groupList.set(i, group);
//        }
//
//        log.info("Succes to insert all test_group!" );
//
//    }
//
//    @AfterAll
//    public static void deleteAll(@Autowired GroupRepository repo) {
//        for(Group group : groupList) {
//            repo.delete(group);
//        }
//
//        log.info("Succes to remove all test_group!");
//    }
//
//    @Test
//    public void createAndDeleteGroupTest() {
//        String groupName = "TestGroupName";
//        Long createUserId = 1000L;
//        String groupDese = "this is TestGroup";
//
//        //Create Test
//        Group group = Group.builder().name(groupName).desc(groupDese) .userId(createUserId).build();
//        group = repo.save(group);
//
//        assertThat(group.getId()).isNotNull();
//        log.info("Succes to Create test_group! => id: " + group.getId() );
//
//        //Delete Test
//        log.debug("delete Group info => id: " + group.getId() + " userid: " + group.getUserId());
//        repo.delete(group);
//
//        Group find = repo.getOne(group.getId());
//        assertThat(repo.getOne(group.getId())).isNull();
//        log.info("Succes to remove test_group! => id: " + group.getId() );
//
//    }
//
//    @Test
//    public void getGroupInfoTest() {
//        for(Group group : groupList) {
//            Group rst = repo.getOne(group.getId());
//
//            assertThat(repo.getOne(rst.getId())).isNull();
//        }
//        log.info("Succes to get test_group!");
//    }
//
//    public void checkGroup(GroupVO g1, GroupVO g2) {
//        assertThat(g1.getGroupId()).isEqualTo(g2.getGroupId());
//        assertThat(g1.getGroupName()).isEqualTo(g2.getGroupName());
//        assertThat(g1.getGroupDesc()).isEqualTo(g2.getGroupDesc());
//        assertThat(g1.getUserId()).isEqualTo(g2.getUserId());
//    }
//
//    @Test
//    public void updateGroupInfoTest() {
//
//    }
//}
