
package com.lue.jeptags.entity;

/**
 *
 * @author lue
 */
public class LoginResponseMessage {
     private LoginMessage message = new LoginMessage();

    public LoginMessage getMessage() {
        return message;
    }

    public void setMessage(LoginMessage message) {
        this.message = message;
    }
     
}
