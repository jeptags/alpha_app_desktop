package com.lue.jeptags.entity;

/**
 *
 * @author lue
 */
public class EditProductList {

    private boolean error;
    private EditProduct message = new EditProduct();

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public EditProduct getMessage() {
        return message;
    }

    public void setMessage(EditProduct message) {
        this.message = message;
    }
}
