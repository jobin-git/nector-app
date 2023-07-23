package com.vishnu.Nectar.controller;

import com.vishnu.Nectar.dto.UserRequest;
import com.vishnu.Nectar.dto.UserResponse;
import com.vishnu.Nectar.entity.User;
import com.vishnu.Nectar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_MANAGER')")
    public String createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PostMapping("/updateUser")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_MANAGER')")
    public String updateUser(@RequestBody UserRequest userRequest) {
        return userService.updateUser(userRequest);
    }

    @PostMapping("/deleteUser/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_MANAGER')")
    public String deleteUser(@RequestParam("id") int id) {
        return userService.deleteUser(id);
    }

    @GetMapping("/getUser")
    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_MANAGER')")
    public List<UserResponse> getAllUsers(){
        return userService.getAllUsers();
    }
}
