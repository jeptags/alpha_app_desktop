package com.lue.jeptags.util;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author lue
 */
public class EncodeLastResponse {
    
    private boolean error;
    private  List<EncodeLast> message =new ArrayList<>();

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<EncodeLast> getMessage() {
        return message;
    }

    public void setMessage(List<EncodeLast> message) {
        this.message = message;
    }

    
}
