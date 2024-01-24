package com.example.codeleader.domain.posts;

import com.example.codeleader.domain.BaseTimeEntity;
import com.example.codeleader.domain.member.Member;
import com.example.codeleader.domain.tech.PostTech;
import com.example.codeleader.domain.tech.Tech;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter @Setter
@Entity
public class Post extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member writer;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<PostTech> techList = new ArrayList<>();


}
