package com.lue.jeptags.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author lue
 */
public class ProductList {

    private boolean error;
    private List<Product> message = new ArrayList<>();

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<Product> getMessage() {
        return message;
    }

    public void setMessage(List<Product> message) {
        this.message = message;
    }

}
