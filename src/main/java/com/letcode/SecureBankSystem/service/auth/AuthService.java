package com.letcode.SecureBankSystem.service.auth;

import com.letcode.SecureBankSystem.bo.auth.AuthenticationResponse;
import com.letcode.SecureBankSystem.bo.auth.CreateLoginRequest;
import com.letcode.SecureBankSystem.bo.auth.CreateSignupRequest;
import com.letcode.SecureBankSystem.bo.auth.LogoutResponse;

public interface AuthService {
    void signup(CreateSignupRequest createSignupRequest);
    AuthenticationResponse login(CreateLoginRequest createLoginRequest);
    void logout (LogoutResponse logoutResponse);

}
