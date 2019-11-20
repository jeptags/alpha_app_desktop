package com.lue.jeptags.util;


/**
 *
 * @author Kundan
 */
public class Response {

    private boolean error;
    
    private String message;

    /**
     * @return the error
     */
    public boolean isError() {
        return error;
    }

    /**
     * @param error the error to set
     */
    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    
}
