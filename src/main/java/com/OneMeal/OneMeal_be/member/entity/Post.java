package com.OneMeal.OneMeal_be.member.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer key;

    @Column(name = "member_id")
    private Integer memberId;

    @Column(name = "material_id")
    private Integer materialId;

    private String title;

    private String content;

    private Integer view;

    private String img_url;

    private String category;

    private Integer serving;

    private Timestamp created_at;

    @ManyToOne
    @JoinColumn(name = "member_id", insertable = false, updatable = false)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "material_id", insertable = false, updatable = false)
    private Material material;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Favorite> favorites;


}
