package com.example.student.potatocorner;

public class Computation {
    private Double price, qty;
    private String name;

    public Computation() {
    }
    public Computation(Double price, Double qty, String name) {
        this.price = price;
        this.qty = qty;
        this.name = name;
    }



    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public double subtotal(){
        return qty*price;
    }
    public double total(){
        return subtotal()+subtotal();
    }
}
