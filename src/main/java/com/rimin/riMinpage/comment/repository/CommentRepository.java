package com.rimin.riMinpage.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rimin.riMinpage.comment.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment,Integer> {

}
