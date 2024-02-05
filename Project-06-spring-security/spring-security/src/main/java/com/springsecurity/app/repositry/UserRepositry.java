package com.springsecurity.app.repositry;

import com.springsecurity.app.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositry extends JpaRepository<UserEntity, Long> {
}
