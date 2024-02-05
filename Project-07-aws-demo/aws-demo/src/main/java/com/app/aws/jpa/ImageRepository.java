package com.app.aws.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.aws.entity.ImageEntity;

public interface ImageRepository extends JpaRepository<ImageEntity, Long> {

}
