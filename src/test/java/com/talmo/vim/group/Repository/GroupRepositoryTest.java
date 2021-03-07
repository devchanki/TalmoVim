package com.talmo.vim.group.Repository;

import com.talmo.vim.group.Group;
import com.talmo.vim.group.GroupRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@Slf4j
@SpringBootTest
public class GroupRepositoryTest {

    @Autowired
    GroupRepository repo;

    private static List<Group> groupList;

    @BeforeAll
    public static void setTestVo(@Autowired GroupRepository repo) {
        groupList = new ArrayList<>();
        groupList.add( Group.builder().name("testgroup1").desc("testdesc1").status("USE").build() );
        groupList.add( Group.builder().name("testgroup2").desc("testdesc2").status("USE").build() );
        groupList.add( Group.builder().name("testgroup3").desc("testdesc3").status("USE").build() );

        for( int i = 0; i < groupList.size(); i++) {
            Group group = repo.save(groupList.get(i));
            groupList.set(i, group);
        }

        log.info("Succes to insert all test_group!" );

    }

    @AfterAll
    public static void deleteAll(@Autowired GroupRepository repo) {
        for(Group group : groupList) {
            repo.delete(group);
        }

        log.info("Succes to remove all test_group!");
    }

    @Test
    @Transactional
    public void createAndDeleteGroupTest() {
        String groupName = "TestGroupName";
        String groupDese = "this is TestGroup";
        String status = "SLP";


        //Create Test
        Group group = Group.builder().name(groupName).desc(groupDese).status(status).build();
        group = repo.save(group);

        assertThat(group.getId()).isNotNull();
        log.info("Succes to Create test_group! => id: " + group.getId() );

        //Delete Test
        log.debug("delete Group info => id: " + group.getId() + " name: " + group.getName());
        repo.delete(group);

        repo.findById(group.getId()).ifPresent( g ->
        {
            log.error("Fail to delete test_group => left group id = " + g.getId());
            failBecauseExceptionWasNotThrown(EntityNotFoundException.class);
        });

        log.info("Succes to delete test_group! => id: " + group.getId() );
    }

    @Test
    @Transactional
    public void getGroupInfoTest() {
        for(Group group : groupList) {
            Group rst = repo.findById(group.getId()).orElseThrow(EntityNotFoundException::new);
            assertThat(rst).isNotNull();
        }
        log.info("Succes to get test_group!");
    }


    @Test
    public void updateGroupInfoTest() {

    }
}
