package com.talmo.vim.user;

import com.talmo.vim.group.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity @Table(name = "TMV_USER")
@Getter @NoArgsConstructor
public class User {

    @Id @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USER_EMAIL", nullable = false)
    private String email;

    @Column(name = "USER_PASSWORD", nullable = false)
    private String password;

    @Column(name = "USER_ROLE", nullable = false)
    private String userRole;

    @Column(name = "USER_NAME", nullable = false)
    private String name;

    @Column(name = "USER_NICK", nullable = false)
    private String nickname;

    @Column(name = "USER_GENDER", nullable = false)
    private String gender;

    @Column(name = "USER_TEL1", nullable = false)
    private String tel1;

    @Column(name = "USER_TEL2", nullable = false)
    private String tel2;

    @Column(name = "USER_TEL3", nullable = false)
    private String tel3;

    @Column(name = "USER_ZIPCODE")
    private String zipcode;

    @Column(name = "USER_ADDR1")
    private String addr1;

    @Column(name = "USER_ADDR2")
    private String addr2;

    @Column(name = "USER_LEVEL")
    private int level;

    @Column(name = "USER_POINT")
    private int point;

    @Column(name = "USER_DI")
    private String di;

    @CreatedDate
    @Column(name = "USER_INSERT_DT")
    private LocalDateTime insertDT;

    @Column(name = "USER_UPDATE_DT")
    private LocalDateTime updateDT;

    @Column(name = "USER_STATUS", nullable = false)
    private String status;

    @Column(name = "USER_LAST_LOGIN_DT")
    private LocalDateTime lastLoginDT;

    @Column(name = "USER_SESSION_ID")
    private String sessionId;

    @Column(name = "USER_SESSION_EXPIRE_DT")
    private LocalDateTime sessionExpireDT;

    @OneToMany(mappedBy = "user")
    private List<Member> members;

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
    public void changePassword(String newPassword) {
        this.password = newPassword;
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
