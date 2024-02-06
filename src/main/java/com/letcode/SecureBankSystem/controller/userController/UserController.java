package com.letcode.SecureBankSystem.controller.userController;

import com.letcode.SecureBankSystem.bo.user.CreateUserRequest;
import com.letcode.SecureBankSystem.bo.user.UpdatedUserRequest;
import com.letcode.SecureBankSystem.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create-user")
    public ResponseEntity<String> createUser(@RequestBody CreateUserRequest createUserRequest) {
        //if we have an illegal error try to save the user and catch error then display the message of the error
        try {
            userService.saveUser(createUserRequest);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());

        }
        return ResponseEntity.ok("User Created Successfully ");
    }

    @PutMapping("/update-user-status")
    public ResponseEntity<String> updateUser(@RequestParam Long userId, @RequestBody UpdatedUserRequest updatedUserRequest) {
        try {
            userService.updatedUserStatus( userId ,updatedUserRequest);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());

        }
        return ResponseEntity.ok("User Updated Successfully ");

    }
}
