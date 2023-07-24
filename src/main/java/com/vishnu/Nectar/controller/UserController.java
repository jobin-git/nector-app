package com.vishnu.Nectar.controller;

import com.vishnu.Nectar.dto.AuthRequest;
import com.vishnu.Nectar.dto.UserRequest;
import com.vishnu.Nectar.dto.UserResponse;
import com.vishnu.Nectar.entity.User;
import com.vishnu.Nectar.service.JwtService;
import com.vishnu.Nectar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;



    @PostMapping("/signup")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_MANAGER')")
    public String createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody AuthRequest authRequest){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(authRequest.getUsername());
        }else{
            throw new UsernameNotFoundException("Invalid user request");
        }
    }

    @PutMapping("/updateUser")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_MANAGER')")
    public String updateUser(@RequestBody UserRequest userRequest) {
        return userService.updateUser(userRequest);
    }

    @DeleteMapping("/deleteUser/{id}")
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
