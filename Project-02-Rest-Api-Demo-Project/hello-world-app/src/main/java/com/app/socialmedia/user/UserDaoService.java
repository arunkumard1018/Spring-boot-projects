package com.app.socialmedia.user;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    public static List<User> users = new ArrayList<User>();
    public static int userCount= 0;
    static {
        users.add(new User(++userCount,"Aruna", LocalDate.now().minusYears(20)));
        users.add(new User(++userCount,"Chirag", LocalDate.now().minusYears(22)));
        users.add(new User(++userCount,"Manoj", LocalDate.now().minusYears(24)));
        users.add(new User(++userCount,"Chandan", LocalDate.now().minusYears(26)));
    }

    public List<User> findAll(){
        return users;
    }

    public User find(int userId) {
        Predicate<? super User> predicate = user -> user.getUserId() == userId;
        return users.stream().filter(predicate).findFirst().orElse(null);// return null if user not found
    }

    public User saveUser(User user) {
        user.setUserId(++userCount);
        users.add(user);
        return user;
    }

    public void deleteUser(int userId) {
        Predicate<? super User> predicate = user -> user.getUserId() == userId;
        users.removeIf(predicate);
    }
}
