package com.lue.jeptags.entity;

/**
 * 
 * @author lue
 */
public class SellerDefaultAddressList {

    private boolean error;
    private SellerMessage message = new SellerMessage();

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public SellerMessage getMessage() {
        return message;
    }

    public void setMessage(SellerMessage message) {
        this.message = message;
    }

}
