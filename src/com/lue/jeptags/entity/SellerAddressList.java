package com.lue.jeptags.entity;

/**
 * 
 * @author lue
 */
public class SellerAddressList {

    private boolean error;
    private SellerAddress message ;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public SellerAddress getMessage() {
        return message;
    }

    public void setMessage(SellerAddress message) {
        this.message = message;
    }

  
}
