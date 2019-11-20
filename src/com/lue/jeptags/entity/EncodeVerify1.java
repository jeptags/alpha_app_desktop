package com.lue.jeptags.entity;

/**
 *
 * @author lue
 */
public class EncodeVerify1 {

    private boolean error;
    private String type;
    private String message;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
