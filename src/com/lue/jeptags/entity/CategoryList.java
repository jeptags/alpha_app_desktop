package com.lue.jeptags.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lue
 */
public class CategoryList {

    private List<Category> object = new ArrayList<>();

    /**
     * @return the object
     */
    public List<Category> getObject() {
        return object;
    }

    /**
     * @param object the object to set
     */
    public void setObject(List<Category> object) {
        this.object = object;
    }

}
