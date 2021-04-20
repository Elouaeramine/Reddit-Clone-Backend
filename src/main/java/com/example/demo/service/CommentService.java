package com.example.demo.service;

import com.example.demo.dto.CommentsDto;
import com.example.demo.exceptions.PostNotFoundException;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final AuthService authService;

    public void save(CommentsDto commentsDto) {
        postRepository.findById(commentsDto.getPostId())
                .orElseThrow(()-> new PostNotFoundException(commentsDto.getPostId().toString()));
    }
}
