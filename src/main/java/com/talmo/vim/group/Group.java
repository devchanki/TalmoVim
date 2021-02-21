package com.talmo.vim.group;

import com.talmo.vim.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter @NoArgsConstructor
public class Group {
    @Id @GeneratedValue
    @Column(name = "GROUP_ID")
    Long id;

    //userid
    @ManyToOne
    @JoinColumn(name = "GROUP_OWNER_ID")
    User owner;

    @Column(name = "GROUP_NAME")
    String name;

    @Column(name = "GROUP_DESC")
    String desc;
    @Builder
    public Group(User owner,String name, String desc) {
        this.owner = owner;
        this.name = name;
        this.desc = desc;
    }
}
