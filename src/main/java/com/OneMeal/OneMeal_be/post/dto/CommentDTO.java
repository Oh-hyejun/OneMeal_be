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
}
