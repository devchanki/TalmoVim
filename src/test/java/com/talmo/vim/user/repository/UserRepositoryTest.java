package com.talmo.vim.user.repository;

import com.talmo.vim.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.talmo.vim.user.*;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository repo;

    private static List<User> testUserList;

    @BeforeAll
    public static void setup(@Autowired UserRepository repo) {
        testUserList = new ArrayList<>();
        testUserList.add(User.builder().email("test1@gmail.com").password("password1").gender("M").userRole("ROLE_USER")
                .nickname("tester1").name("test1").status("USE").level(0).point(0).tel1("000").tel2("0000").tel3("0000").build());
        testUserList.add(User.builder().email("test2@naver.com").password("password2").gender("W").userRole("ROLE_USER")
                .nickname("tester2").name("test2").status("SLP").level(1).point(200).tel1("100").tel2("1000").tel3("0001").build());
        testUserList.add(User.builder().email("test3@hanmail.com").password("password3").gender("W").userRole("ROLE_USER")
                .nickname("tester3").name("test3").status("USE").level(2).point(1000).tel1("200").tel2("2000").tel3("0002").build());
        testUserList.add(User.builder().email("test4@daum.com").password("password4").gender("M").userRole("ROLE_USER")
                .nickname("tester4").name("test4").status("USE").level(3).point(5000).tel1("300").tel2("3000").tel3("0003").build());

        for (int i =0; i< testUserList.size(); i++ ) {
            User user = testUserList.get(i);
            Optional<User> entity = repo.findByEmail(user.getEmail());
            if(entity.isPresent()) continue;
            repo.save(user);
        }
    }

    @AfterAll
    public static void end(@Autowired UserRepository repo) {
        for(User user : testUserList) {
            Long id = user.getId();
            if(id == null) continue;
            Optional<User> entity = repo.findById(id);
            entity.ifPresent(u -> {repo.delete(u);});
        }
    }

    @Test
    @Transactional
    public void createAndDeleteGroupTest() {
        User addUser = User.builder().email("CXXDTest@testmail.abc").password("CXXDpasswordd").gender("M").userRole("ROLE_TEST")
                .nickname("test_user").name("test_user").status("USE").level(0).point(0).tel1("123").tel2("1234").tel3("1234").build();

        User addedUser = repo.save(addUser);

        assertThat(addedUser.getId()).isEqualTo(addUser.getId());
        log.info("Success to Create test_user");

        repo.delete(addUser);
        User user = repo.findById(addUser.getId()).orElse(null);

        assertThat(user).isNull();
        log.info("Success to Delete test_user");
    }

    public void printUserToLog(User user) {
        log.info("id : " + user.getId());
        log.info("email : " + user.getEmail());
        log.info("password : " +  user.getPassword());
        log.info("nickname : " + user.getNickname());
        log.info("Tel : " + user.getTel("-"));
        log.info("Gender : " + user.getGender());
        log.info("Created Date : " + user.getInsertDT() + "\n");
    }

    @Test
    public void findByTest() {
        //find by email
        for(User user : testUserList) {
            User u = repo.findByEmail(user.getEmail()).orElseThrow(EntityNotFoundException::new);
            assertThat(u.getId()).isEqualTo(user.getId());
            printUserToLog(u);
        }
        log.info("Succes to find user by email ");

    }

    @Test
    public void findAllByTest() {
        //find by gender
        List<User> users = repo.findAllByGender(testUserList.get(0).getGender());
        assertThat(users.isEmpty()).isFalse();

        for(User user : users) {
            assertThat(user.getGender()).isEqualTo("M");
        }
        log.info("Succes to find users by gender ");

        for(User user : users) {
            printUserToLog(user);
        }
    }

    @Test
    @Transactional
    public void ChangeNickname() {
        User user = repo.findById(testUserList.get(0).getId()).orElseThrow(EntityNotFoundException::new);
        String changeNickname = "tester001";
        user.changeNickname(changeNickname);
        repo.save(user);

        User expectedUser = repo.findById(user.getId()).orElseThrow(EntityNotFoundException::new);
        assertThat(expectedUser.getNickname()).isEqualTo(changeNickname);
    }

    @Test
    public void updateGroupInfoTest() {
    }
}
