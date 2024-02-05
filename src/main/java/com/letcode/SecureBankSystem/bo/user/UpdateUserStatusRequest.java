package com.letcode.SecureBankSystem.bo.user;

public class UpdateUserStatusRequest {
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private Long userId;
    private String username;
    private String status;

}


// we should put if statment !!!
