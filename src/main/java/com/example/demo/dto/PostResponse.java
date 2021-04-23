package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {
    private Long id;
    private String postName;
    private String url;
    private String description;
    private String username;
    private String subredditName;

    // New  Fields
    private Integer voteCount;
    private Integer commentCount;
    private String duration ;
}
