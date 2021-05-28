package co.edu.umb.ds.orderhistory.model.entities;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity{name = "order_history"}
@Table{name = "order_history"}

public class OrderHistory {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column (name = "id", updatable = false)
    private Long id;

    @Column(name = "username", nullable = false, columnDefinition = "TEXT")
    private String username;

    @Column(name = "price", nullable = false, columnDefinition = "FLOAT")
    private float price;

    @Column(name = "date", nullable = false, columnDefinition = "DATE")
    private Date date;

    @Column(name = "quantity", nullable = false, columnDefinition = "INT")
    private int quantity;

    @Column(name = "address", nullable = false, columnDefinition = "TEXT")
    private String address;

    public OrderHistory(Long id, String username, float price, Date date, int quantity, String address) {
        this.id = id;
        this.username = username;
        this.price = price;
        this.date = date;
        this.quantity = quantity;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
