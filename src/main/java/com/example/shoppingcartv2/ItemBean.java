package com.example.shoppingcartv2;

import java.io.Serializable;

/**
 * Java bean class for each item object of the cart
 */
public class ItemBean implements Serializable {
    private int quantity;
    private int price;
    private String name;
    private String imageurl;

    ItemBean() {

    }

    ItemBean(String name, int quantity, int price){
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }

    ItemBean(String name, int quantity, int price, String imageurl){
        this.name=name;
        this.price=price;
        this.quantity=quantity;
        this.imageurl= imageurl;
    }

    public  String getName(){ return  name;}

    public void setName(String name) {
        this.name= name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity= quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public  String getImageurl(){ return  imageurl;}

    public void setImageurl(String imageurl) {
        this.imageurl= imageurl;
    }

}
