package com.lue.jeptags.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lue
 */
public class BrandList {

    private boolean error;
    private List<Brand> message = new ArrayList();

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<Brand> getMessage() {
        return message;
    }

    public void setMessage(List<Brand> message) {
        this.message = message;
    }

}
