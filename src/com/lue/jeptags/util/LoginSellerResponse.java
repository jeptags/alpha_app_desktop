package com.lue.jeptags.util;

import com.lue.jeptags.entity.LoginMessage;

/**
 * 
 * @author lue
 */
public class LoginSellerResponse {

    private boolean error;
    private String role;
    private LoginMessage message = new LoginMessage();

    public LoginMessage getMessage() {
        return message;
    }

    public void setMessage(LoginMessage message) {
        this.message = message;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

}
