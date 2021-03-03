package com.talmo.vim.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity @Table(name = "TMV_USER")
@Getter @NoArgsConstructor
public class User {

    @Id @Column(name = "CODE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "USER_ROLE", nullable = false)
    private String userRole;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "NICK", nullable = false)
    private String nickname;

    @Column(name = "GENDER", nullable = false)
    private String gender;

    @Column(name = "TEL1", nullable = false)
    private String tel1;

    @Column(name = "TEL2", nullable = false)
    private String tel2;

    @Column(name = "TEL3", nullable = false)
    private String tel3;

    @Column(name = "ZIPCODE")
    private String zipcode;

    @Column(name = "ADDR1")
    private String addr1;

    @Column(name = "ADDR2")
    private String addr2;

    @Column(name = "LEVEL")
    private int level;

    @Column(name = "POINT")
    private int point;

    @Column(name = "DI")
    private String di;

    @CreatedDate
    @Column(name = "INSERT_DT")
    private LocalDateTime insertDT;

    @Column(name = "UPDATE_DT")
    private LocalDateTime updateDT;

    @Column(name = "STATUS", nullable = false)
    private String status;

    @Column(name = "LAST_LOGIN_DT")
    private LocalDateTime lastLoginDT;

    @Column(name = "SESSION_ID")
    private String sessionId;

    @Column(name = "SESSION_EXPIRE_DT")
    private LocalDateTime sessionExpireDT;

    @Builder
    public User(String email, String password, String userRole, String name,String nickname, String gender,
                String tel1, String tel2, String tel3, String zipcode, String addr1, String addr2,
                int level, int point, String di, LocalDateTime updateDT, String status) {
        this.email = email; this.password = password; this.userRole = userRole; this.name = name; this.nickname = nickname;
        this.gender = gender; this.tel1 = tel1; this.tel2 = tel2; this.tel3 = tel3;
        this.zipcode = zipcode; this.addr1 = addr1; this.addr2 = addr2;
        this.level = level; this.point = point;
        this.di = di;
        this.updateDT = updateDT; this.status = status;
    }

    public void changeNickname(String nickname) {
        this.nickname = nickname;
        this.updateDT = LocalDateTime.now();
    }

    //TODO : password 암호화를 어디에 둘것인가? (service, security, entity, etc)
    public void changePassword() {
        this.password = password;
        this.updateDT = LocalDateTime.now();
    }

    public void loginPunched(){
        this.lastLoginDT = LocalDateTime.now();
    }

    public String getTel(String split) {
        StringBuilder sb = new StringBuilder();
        sb.append(tel1);sb.append(split);
        sb.append(tel2);sb.append(split);
        sb.append(tel3);

        return sb.toString();
    }
}
