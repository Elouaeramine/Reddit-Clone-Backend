package com.example.demo.mapper;


import com.example.demo.dto.PostRequest;
import com.example.demo.dto.PostResponse;
import com.example.demo.model.Post;
import com.example.demo.model.Subreddit;
import com.example.demo.model.User;
import com.example.demo.repository.CommentRepository;
import com.github.marlonlom.utilities.timeago.TimeAgo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class PostMapper {

    @Autowired
    private CommentRepository commentRepository;

    @Mapping(target = "createdDate" ,expression = "java(java.time.Instant.now())")
    @Mapping(target = "description" , source = "postRequest.description")
    @Mapping(target = "voteCount", constant = "0")
    public abstract Post map(PostRequest postRequest, Subreddit subreddit , User user);

    @Mapping(target = "id" ,source = "postId")
    @Mapping(target = "subredditName" , source = "subreddit.name")
    @Mapping(target = "username" , source = "user.username")
    @Mapping(target = "commentCount" , expression = "java(commentCount(post))")
    @Mapping(target = "duration" , expression = "java(getDuration(post))")
    public abstract PostResponse mapToDto(Post post);

    Integer commentCount(Post post) {
        return commentRepository.findByPost(post).size();
    }

    String getDuration(Post post) {
        return TimeAgo.using(post.getCreatedDate().toEpochMilli());
    }


}
