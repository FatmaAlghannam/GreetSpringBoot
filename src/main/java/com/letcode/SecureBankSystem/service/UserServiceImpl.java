package com.letcode.SecureBankSystem.service;

import com.letcode.SecureBankSystem.bo.user.CreateUserRequest;
import com.letcode.SecureBankSystem.bo.user.UpdatedUserRequest;
import com.letcode.SecureBankSystem.entity.UserEntity;
import com.letcode.SecureBankSystem.repository.UserRepository;
import com.letcode.SecureBankSystem.util.enums.Status;
import org.springframework.stereotype.Service;

@Service

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(CreateUserRequest createUserRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(createUserRequest.getName());
        userEntity.setEmail(createUserRequest.getEmail());
        userEntity.setPhone(createUserRequest.getPhone());
        userEntity.setStatus(Status.valueOf(createUserRequest.getStatus()));
        userRepository.save(userEntity);


    }

    @Override
    public void updatedUserStatus(Long userId ,UpdatedUserRequest updatedUserRequest) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow();
        if (!updatedUserRequest.getStatus().equals("ACTIVE") && !updatedUserRequest.getStatus().equals("INACTIVE")){
            //go into the error :throw
            throw new IllegalArgumentException("The status should be ACTIVE or INACTIVE");
        }

            userEntity.setStatus(Status.valueOf(updatedUserRequest.getStatus()));
        userRepository.save(userEntity);
    }
}
