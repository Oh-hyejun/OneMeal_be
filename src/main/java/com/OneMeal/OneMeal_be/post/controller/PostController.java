package com.OneMeal.OneMeal_be.post.controller;

import com.OneMeal.OneMeal_be.post.dto.PostDTO;
import com.OneMeal.OneMeal_be.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class PostController {

    private final PostService postService;

    @GetMapping("/detail/{id}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable Integer id) {
        PostDTO postDTO = postService.findPostById(id);
        return ResponseEntity.ok(postDTO);
    }
}
