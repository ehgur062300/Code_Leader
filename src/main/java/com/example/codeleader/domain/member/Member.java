package com.example.codeleader.domain.member;

import com.example.codeleader.domain.BaseTimeEntity;
import com.example.codeleader.domain.posts.Post;
import com.example.codeleader.domain.tech.Tech;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter @Setter
@Entity
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String memberName;

    private String password;

    private String nickName;

    private String email;

    private Role role;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Tech> techList = new ArrayList<>();

    @OneToMany(mappedBy = "writer", cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();

    @Builder
    public Member(String memberName, String password, String nickName, String email, Role role) {
        this.memberName = memberName;
        this.password = password;
        this.nickName = nickName;
        this.email = email;
        this.role = role;
    }

    public Member update(String memberName, String password, String nickName, String email, Role role){
        this.memberName = memberName;
        this.password = password;
        this.nickName = nickName;
        this.email = email;
        this.role = role;

        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}

