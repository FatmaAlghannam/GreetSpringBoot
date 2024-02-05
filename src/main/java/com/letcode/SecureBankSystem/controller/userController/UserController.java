package com.letcode.SecureBankSystem.controller.userController;

import com.letcode.SecureBankSystem.bo.user.CreateUserRequest;
import com.letcode.SecureBankSystem.bo.user.UpdateUserStatusRequest;
import com.letcode.SecureBankSystem.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/create-user")
    public ResponseEntity<String > createUser(@RequestBody CreateUserRequest createUserRequest){
        userService.saveUser(createUserRequest);
        return  ResponseEntity.ok("User Created Successfully ");
    }

//    @PostMapping("/updateStatus")
//    public ResponseEntity<String > updateStatus(@RequestParam UpdateUserStatusRequest newStatus){
//        userService.updateStatus(newStatus);
//        return  ResponseEntity.ok("Status updated Successfully! ");
//    }

}
