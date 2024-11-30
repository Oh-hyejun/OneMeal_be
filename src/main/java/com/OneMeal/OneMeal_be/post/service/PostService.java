package com.OneMeal.OneMeal_be.post.service;

import com.OneMeal.OneMeal_be.entity.Post;
import com.OneMeal.OneMeal_be.post.dto.PostDTO;
import com.OneMeal.OneMeal_be.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public PostDTO findPostById(Integer id) {
        Post post = postRepository.findPostById(id);

        PostDTO postDetail = new PostDTO(post);




        return postDetail;
    }
}
