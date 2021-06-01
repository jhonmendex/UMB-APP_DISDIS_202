package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shopping_cart")
public class ShoppingCartEntity {
	
	@Id
	@GeneratedValue(generator = "ShoppingCartEntityGenerator",strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalṔrice() {
		return totalṔrice;
	}

	public void setTotalṔrice(double totalṔrice) {
		this.totalṔrice = totalṔrice;
	}

	public double getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(double idProduct) {
		this.idProduct = idProduct;
	}

	@Column(name="quantity")
	private int quantity;
	
	@Column(name="total_price")
	private double totalṔrice;
	
	@Column(name="id_product")
	private double idProduct;
	

}
