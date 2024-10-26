package com.rcoem.devops.services;

import com.rcoem.devops.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    HashMap<String, User> users;

    @PostConstruct
    public void setup(){
        users=new HashMap<>();
    }
    public String createUser(User user){
        user.setUserId(UUID.randomUUID().toString());
        users.put(user.getUserId(),user);
        return user.getUserId();
    }
    public List<User> getAllUsers(){
    return users.values().stream().collect(Collectors.toList());
    }

    public User getUser(String id) {
        return    users.getOrDefault(id,null);
    }
}
