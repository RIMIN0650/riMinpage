package com.rimin.riMinpage.like.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rimin.riMinpage.like.domain.Like;

public interface LikeRepository extends JpaRepository<Like, Integer>  {
// generic : entity class & primary key type
}
