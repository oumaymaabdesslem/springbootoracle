package com.example.springbootoracle;

public class Sale {
    private int id;
    private String item;
    private int quantity;
    private float amount;
    public Sale() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Sale(String item, int quantity, float amount) {
        super();
        this.item = item;
        this.quantity = quantity;
        this.amount = amount;
    }
    //getter and setter
    //toString

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getItem() {
        return item;
    }
    public void setItem(String item) {
        this.item = item;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public float getAmount() {
        return amount;
    }
    public void setAmount(float amount) {
        this.amount = amount;
    }
    @Override
    public String toString() {
        return "Scale [id=" + id + ", item=" + item + ", quantity=" + quantity + ", amount=" + amount + "]";
    }

}
