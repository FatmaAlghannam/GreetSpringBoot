package com.letcode.SecureBankSystem.service;

import com.letcode.SecureBankSystem.bo.user.CreateUserRequest;
import com.letcode.SecureBankSystem.bo.user.UpdatedUserRequest;

public interface UserService {
    void saveUser(CreateUserRequest createUserRequest);

    void updatedUserStatus(Long userId,UpdatedUserRequest updatedUserRequest);
}

