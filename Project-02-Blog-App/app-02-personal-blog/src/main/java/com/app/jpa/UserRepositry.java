package com.app.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.entity.UserEntity;

public interface UserRepositry extends JpaRepository<UserEntity, String> {

}
