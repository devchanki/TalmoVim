package com.talmo.vim.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @NoArgsConstructor
public class User {

    @Id @Column(name = "USER_ID")
    @GeneratedValue
    private Long id;

    @Column(name = "USER_EMAIL")
    private String email;

    @Column(name = "USER_NICKNAME")
    private String nickname;

    @Column(name = "USER_PASSWORD")
    private String password;

    @Builder
    public User(String email, String nickname, String password) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
    }
}
