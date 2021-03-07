package com.talmo.vim.group;

import com.talmo.vim.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity @Table(name = "TMV_MEMBER")
@NoArgsConstructor @Getter
public class Member {
    @Id @Column(name = "MEMBER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    private Group group;

    @Column(name = "MEMBER_ROLE")
    private String role;

    @Column(name = "MEMBER_STATUS")
    private String status;

    @CreatedDate
    @Column(name = "MEMBER_REGIST_DT")
    LocalDateTime registDT;

    @Builder
    public Member(User user, Group group, String role, String status) {
        this.user = user; this.group = group;
        this.role = role; this.status = status;
    }
}
