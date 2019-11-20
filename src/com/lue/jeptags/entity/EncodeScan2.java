package com.lue.jeptags.entity;
/**
 * 
 * @author lue
 */
public class EncodeScan2 {

    private boolean error;
    private int type;
    private EncodeScanMessage2 message = new EncodeScanMessage2();

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public EncodeScanMessage2 getMessage() {
        return message;
    }

    public void setMessage(EncodeScanMessage2 message) {
        this.message = message;
    }
}
