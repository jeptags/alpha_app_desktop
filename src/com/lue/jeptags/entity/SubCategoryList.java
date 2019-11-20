package com.lue.jeptags.entity;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author lue
 */
public class SubCategoryList {

    private boolean error;
    private List<SubCategory> message = new ArrayList<>();

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<SubCategory> getMessage() {
        return message;
    }

    public void setMessage(List<SubCategory> message) {
        this.message = message;
    }
    
    
}
