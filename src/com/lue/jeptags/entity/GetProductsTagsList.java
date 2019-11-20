
package com.lue.jeptags.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lue
 */
public class GetProductsTagsList {
    private boolean error;
    List<GetProductTags> message=new ArrayList<>();

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<GetProductTags> getMessage() {
        return message;
    }

    public void setMessage(List<GetProductTags> message) {
        this.message = message;
    }
    
    
}
