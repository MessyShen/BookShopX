package com.book.entity;

import java.io.Serializable;

public class CartItemBean implements Serializable{
    private Books bk;

    public Books getBk() {
        return bk;
    }

    public void setBk(Books bk) {
        this.bk = bk;
    }

    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public CartItemBean(Books bk, int quantity) {
        super();
        this.bk = bk;
        this.quantity = quantity;
    }
}
