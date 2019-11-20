package com.lue.jeptags.entity;

/**
 *
 * @author lue
 */
public class SellerProfileResponse {

    private boolean error;
    private SellerProfile message = new SellerProfile();

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public SellerProfile getMessage() {
        return message;
    }

    public void setMessage(SellerProfile message) {
        this.message = message;
    }

   
}
