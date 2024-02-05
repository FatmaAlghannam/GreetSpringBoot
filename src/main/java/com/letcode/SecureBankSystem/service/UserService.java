package com.letcode.SecureBankSystem.service;

import com.letcode.SecureBankSystem.bo.user.CreateUserRequest;
import com.letcode.SecureBankSystem.bo.user.enums.Status;

import java.util.List;

public interface UserService {
    void saveUser(CreateUserRequest createUserRequest);
}

