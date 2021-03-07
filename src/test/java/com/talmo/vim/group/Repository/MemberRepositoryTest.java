package com.talmo.vim.group.repository;

import com.talmo.vim.group.Group;
import com.talmo.vim.group.GroupRepository;
import com.talmo.vim.group.Member;
import com.talmo.vim.group.MemberRepository;
import com.talmo.vim.user.User;
import com.talmo.vim.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class MemberRepositoryTest {

    @Autowired
    GroupRepository groupRepo;

    @Autowired
    UserRepository userRepo;

    @Autowired
    MemberRepository memberRepo;

    @Test
    @Transactional
    public void joinTest() {
        User user = userRepo.findByEmail("ohj8447@tester.com").orElseThrow(EntityNotFoundException::new);
        Group group = groupRepo.findById(9L).orElseThrow(EntityNotFoundException::new);

        Member member = Member.builder().user(user).group(group).role("ADMIN").status("TEST").build();
        memberRepo.save(member);

        user = userRepo.findById(user.getId()).orElseThrow(EntityNotFoundException::new);
        group = groupRepo.findById(group.getId()).orElseThrow(EntityNotFoundException::new);

        List<Member> membersByUser = user.getMembers();
        List<Member> membersByGroup = group.getMembers();

        assertThat(membersByUser.get(0).getGroup().getId()).isEqualTo(group.getId());
        assertThat(membersByGroup.get(0).getUser().getId()).isEqualTo(user.getId());
    }

}
