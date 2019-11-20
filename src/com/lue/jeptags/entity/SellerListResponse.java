package com.lue.jeptags.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lue
 */
public class SellerListResponse {

    private boolean error;
    private List<Sellers> message = new ArrayList<>();

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<Sellers> getMessage() {
        return message;
    }

    public void setMessage(List<Sellers> message) {
        this.message = message;
    }

}
