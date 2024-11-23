package com.OneMeal.OneMeal_be.post.dto;

import com.OneMeal.OneMeal_be.entity.Comment;
import com.OneMeal.OneMeal_be.member.dto.MemberDTO;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class CommentDTO {
    private Integer id;
    private PostDTO post;
    private MemberDTO member;
    private String content;
    private Timestamp created_at;


    public CommentDTO(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getContent();
        this.created_at = comment.getCreated_at();

        if (comment.getPost() != null) {
            this.post = new PostDTO(comment.getPost());
        }

        if (comment.getMember() != null) {
            this.member = new MemberDTO(comment.getMember());
        }
    }
}
