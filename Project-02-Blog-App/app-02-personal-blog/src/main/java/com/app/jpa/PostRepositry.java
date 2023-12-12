package com.app.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.PostEntity;

public interface PostRepositry extends JpaRepository<PostEntity, Integer> {

}
