package com.OneMeal.OneMeal_be.post.dto;

import com.OneMeal.OneMeal_be.entity.Post;
import com.OneMeal.OneMeal_be.member.dto.MemberDTO;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class PostDTO {
    private Integer key;
    private String title;
    private String content;
    private Integer view;
    private String imgUrl;
    private String category;
    private Integer serving;
    private Timestamp createdAt;
    private MemberDTO member;
    private List<MaterialDTO> materials;
    private List<CommentDTO> comments;

    public PostDTO(Post post) {
        this.key = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.view = post.getView();
        this.imgUrl = post.getImg_url();
        this.category = post.getCategory();
        this.serving = post.getServing();
        this.createdAt = post.getCreated_at();

        // Member 엔티티를 DTO로 변환
        if (post.getMember() != null) {
            this.member = new MemberDTO(post.getMember());
        }

        // Material 엔티티 리스트를 DTO로 변환
        if (post.getMaterials() != null) {
            this.materials = post.getMaterials().stream()
                    .map(MaterialDTO::new)
                    .collect(Collectors.toList());
        }

        // Comment 엔티티 리스트를 DTO로 변환
        if (post.getComments() != null) {
            this.comments = post.getComments().stream()
                    .map(CommentDTO::new)
                    .collect(Collectors.toList());
        }
    }
}
