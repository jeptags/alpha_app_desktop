
package com.lue.jeptags.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lue
 */
public class EncodeVerifyResponse {
    private boolean error;
     private List<EncodeVerify> message = new ArrayList<>();

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<EncodeVerify> getMessage() {
        return message;
    }

    public void setMessage(List<EncodeVerify> message) {
        this.message = message;
    }

    
}
