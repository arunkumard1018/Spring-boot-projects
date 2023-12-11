package com.app.socialmedia.user;

import com.app.socialmedia.exception.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {
    private UserDaoService userDaoService;

    public UserResource(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @GetMapping("/users")
    public List<User> retriveAllUsers(){
        return userDaoService.findAll();
    }

    /**
     * return 404 - resource Not Found if no user found
     * */
    @GetMapping("/users/{userId}")
    public User retriveUser(@PathVariable int userId){
        User user = userDaoService.find(userId);
        if(user == null){
            throw new UserNotFoundException("id : "+userId);
        }else{
            return user;
        }
    }

    /**
     * ServletUriComponentsBuilder.fromCurrentRequest()
     * return Current Request Uri "/users"
     * .path("/{userId}") to add path to uri i.e "/users/{userId}"
     * .buildAndExpand(savedUser.getUserId()) i.e "/users/{saved user iD}"
     *
     * ResponseEntity.created(location).build(); returning 201 status code i.e resource created
     * */
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User savedUser = userDaoService.saveUser(user);

        URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{userId}")
                        .buildAndExpand(savedUser.getUserId())
                        .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable int userId){
        userDaoService.deleteUser(userId);
    }

}
