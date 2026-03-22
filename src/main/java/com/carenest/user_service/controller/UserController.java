package com.carenest.user_service.controller;

import com.carenest.user_service.model.common.ApiResponse;
import com.carenest.user_service.model.entity.User;
import com.carenest.user_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody User user){

        userService.saveUser(user);
        return  ResponseEntity.ok("user created successfully");
    }

    @GetMapping("/index")
    public ResponseEntity<ApiResponse<List<User>>> getAllUsers(){
        List<User> users = userService.findAllUsers();
        if(users.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        ApiResponse<List<User>> response = ApiResponse.<List<User >>builder()
                .timeStamp(LocalDateTime.now())
                .status(200)
                .message(users.isEmpty() ? "No users found": "users fetched successfully")
                .data(users)
                .build();
        return ResponseEntity.ok(response);
    }
}
