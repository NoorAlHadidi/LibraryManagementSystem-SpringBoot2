package com.brightskies.hotelsystem.controller;

import com.brightskies.hotelsystem.dto.UserDTO;
import com.brightskies.hotelsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/user")
@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody UserDTO userDTO) throws Exception {
        try {
            userService.addUser(userDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
        }
        catch(Exception exception) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
        }
    }

    @GetMapping("/display")
    public ResponseEntity<List<UserDTO>> displayUsers() {
        return ResponseEntity.ok(userService.displayUsers());
    }
}
