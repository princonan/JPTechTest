package com.jptest.model;

public class Sale {
	private int amount;
	private Product product;
	
	@Override
	public boolean equals(Object obj) {
		Sale emp = (Sale) obj;
        boolean status = false;
        if(this.amount==emp.getAmount()
                && this.product.getProductName().equals(emp.getProduct().getProductName())
                && this.product.getProductType().equals(emp.getProduct().getProductType())
                && this.product.getProductValue()==emp.getProduct().getProductValue()){
            status = true;
        }
        return status;
	}
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int d) {
		this.amount = d;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
}
