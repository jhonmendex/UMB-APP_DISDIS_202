package co.edu.umb.ds.shoppingcart;

public class Carrito {
    int id;
    int quantity;
    double total_price;
    int id_product;
    
    public Carrito() {
    }

    public Carrito(int id, int quantity, double total_price, int id_product) {
        this.id = id;
        this.quantity = quantity;
        this.total_price = total_price;
        this.id_product = id_product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }
    
}

   