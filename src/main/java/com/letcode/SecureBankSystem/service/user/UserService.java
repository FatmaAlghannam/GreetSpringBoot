package com.letcode.SecureBankSystem.service.user;

import com.letcode.SecureBankSystem.bo.user.CreateUserRequest;
import com.letcode.SecureBankSystem.bo.user.UpdatedUserRequest;

import java.util.List;

public interface UserService {
    void saveUser(CreateUserRequest createUserRequest);

    void updatedUserStatus(Long userId,UpdatedUserRequest updatedUserRequest);

    List<String> getAllUserWithStrongPassword();

}

