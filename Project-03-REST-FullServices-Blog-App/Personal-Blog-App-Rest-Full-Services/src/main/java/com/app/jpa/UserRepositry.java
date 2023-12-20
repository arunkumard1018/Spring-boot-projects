package com.app.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.users.User;

public interface UserRepositry extends JpaRepository<User, Integer> {

}
