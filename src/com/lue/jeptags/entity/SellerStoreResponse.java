/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lue.jeptags.entity;

/**
 *
 * @author lue
 */
public class SellerStoreResponse {
    private boolean error;
    private SellerStoreAddress message;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public SellerStoreAddress getMessage() {
        return message;
    }

    public void setMessage(SellerStoreAddress message) {
        this.message = message;
    }
}
