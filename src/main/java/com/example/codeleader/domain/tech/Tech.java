package com.example.codeleader.domain.tech;

import com.example.codeleader.domain.member.Member;
import com.example.codeleader.domain.posts.Post;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Tech {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tech_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "tech", cascade = CascadeType.ALL)
    private List<PostTech> postTechList = new ArrayList<>();

    @Column(unique = true)
    private String techName;
}
