package com.talmo.vim.group;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface MemberRepository extends JpaRepository<Member, Long> {
}
