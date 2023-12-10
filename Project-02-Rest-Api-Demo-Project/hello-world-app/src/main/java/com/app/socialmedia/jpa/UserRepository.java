package com.app.socialmedia.jpa;

import com.app.socialmedia.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
