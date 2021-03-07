package com.talmo.vim.group;

import com.talmo.vim.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity @Table(name = "TMV_GROUP")
@Getter @NoArgsConstructor
public class Group {
    @Id @Column(name = "GROUP_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "GROUP_NAME")
    String name;

    @Column(name = "GROUP_DESC")
    String desc;

    @Column(name = "GROUP_STATUS")
    String status;

    @CreatedDate
    @Column(name = "GROUP_INSERT_DT")
    LocalDateTime insertDT;

    @OneToMany(mappedBy = "group")
    List<Member> members;

    @Builder
    public Group(String name, String desc, String status) {
        this.name = name;
        this.desc = desc;
        this.status = status;
    }
}
