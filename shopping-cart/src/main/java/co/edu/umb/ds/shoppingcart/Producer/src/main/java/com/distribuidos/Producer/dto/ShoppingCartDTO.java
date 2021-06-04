package com.example.demo.dto;

public class ShoppingCartDTO {
	
	public int getQuantity() {
		return quantity;
	}

	public ShoppingCartDTO(int quantity, double totalṔrice, double idProduct) {
		super();
		this.quantity = quantity;
		this.totalṔrice = totalṔrice;
		this.idProduct = idProduct;
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

	private int quantity;
	
	private double totalṔrice;
	
	private double idProduct;


}
