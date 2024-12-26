package com.hospify.main.Response;

import com.hospify.main.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserResponse {
    private User user;
    private String successMessage;
    private String failureMessage;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    public String getFailureMessage() {
        return failureMessage;
    }

    public void setFailureMessage(String failureMessage) {
        this.failureMessage = failureMessage;
    }
}
