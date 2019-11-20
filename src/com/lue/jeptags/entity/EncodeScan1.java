package com.lue.jeptags.entity;
/**
 * 
 * @author lue
 */
public class EncodeScan1 {

    private boolean error;
    private int type;
    private EncodeScanMessage1 message = new EncodeScanMessage1();

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

    public EncodeScanMessage1 getMessage() {
        return message;
    }

    public void setMessage(EncodeScanMessage1 message) {
        this.message = message;
    }
}
