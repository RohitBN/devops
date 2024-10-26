package com.rcoem.devops.interfaces;

import com.rcoem.devops.User;
import com.rcoem.devops.services.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    UserService userService;
    @PostMapping()
    ResponseEntity<String> createUser(@RequestBody User user){
        return ResponseEntity.status(201).body(userService.createUser(user));
    }
    @GetMapping()
    List<User> createUser(){
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    User getUser(@PathVariable String id){
        return userService.getUser(id);
    }

}
