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
    private Integer id;
    private String title;
    private String content;
    private Integer view;
    private String imgUrl;
    private String category;
    private Integer serving;
    private Timestamp createdAt;
    private MemberDTO member;
    private List<CommentDTO> comments;

}
