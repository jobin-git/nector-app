package com.vishnu.Nectar.controller;

import com.vishnu.Nectar.dto.UserResponse;
import com.vishnu.Nectar.entity.User;
import com.vishnu.Nectar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/getUser")
    @PreAuthorize("hasAuthority('ROLE_USER','ROLE_ADMIN')")
    public List<UserResponse> getAllUsers(){
        return userService.getAllUsers();
    }
}
