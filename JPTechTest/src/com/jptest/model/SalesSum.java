package com.jptest.model;

public class SalesSum {

	private String productName;
	private int productAmount;
	private double totalPrice;
	
	@Override
	public boolean equals(Object obj) {
		SalesSum emp = (SalesSum) obj;
        boolean status = false;
        if(this.productAmount==emp.getProductAmount()
                && this.productName.equals(emp.getProductName())
                && this.totalPrice==emp.getTotalPrice()){
            status = true;
        }
        return status;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductAmount() {
		return productAmount;
	}
	public void setProductAmount(int productAmount) {
		this.productAmount = productAmount;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
}
