package com.distribuidos.Producer.Model;

public class Producto {
    
    int id;
    String name;
    double price;
    int id_product_type;     
    
    public Producto(){
    }

    public Producto(int id, String name, double price, int id_product_type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.id_product_type = id_product_type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId_product_type() {
        return id_product_type;
    }

    public void setId_product_type(int id_product_type) {
        this.id_product_type = id_product_type;
    }
  
}