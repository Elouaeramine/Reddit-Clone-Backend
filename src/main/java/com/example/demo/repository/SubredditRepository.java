package com.example.demo.repository;

import com.example.demo.model.Subreddit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubredditRepository extends JpaRepository <Subreddit, Long> {

     Optional<Subreddit> findByName(String subredditName);
}
