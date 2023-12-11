package com.app.socialmedia.user;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity(name = "user_details")
public class User {

    @Id
    @GeneratedValue
    private int userId;
    @Size(min = 5, max = 20, message = "Name Must Be Minimum 5chars and max 20 chars")
    private String name;
    @Past(message = "date must be in Past")
    private LocalDate dob;

    public User() {
    }

    public User(int userId, String name, LocalDate dob) {
        this.userId = userId;
        this.name = name;
        this.dob = dob;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
