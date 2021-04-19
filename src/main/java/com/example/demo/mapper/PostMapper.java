package com.example.demo.mapper;

import com.example.demo.dto.PostRequest;
import com.example.demo.dto.PostResponse;
import com.example.demo.model.Post;
import com.example.demo.model.Subreddit;
import com.example.demo.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostMapper {
    @Mapping(target = "createdDate" ,expression = "java(java.time.Instant.now())")
    @Mapping(target = "description" , source = "postRequest.description")
    Post map(PostRequest postRequest, Subreddit subreddit , User user);

    @Mapping(target = "id" ,source = "postId")
    @Mapping(target = "subredditName" , source = "subreddit.name")
    @Mapping(target = "username" , source = "user.username")
    PostResponse mapToDto(Post post);

}
