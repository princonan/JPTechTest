package com.jptest.model;

public class Product {
	private String productName;
	private String productType;
	private double productValue;
	
	@Override
	public boolean equals(Object obj) {
		Product emp = (Product) obj;
        boolean status = false;
        if(this.productValue==emp.getProductValue()
                && this.productName.equals(emp.getProductName())
                && this.productType.equals(emp.getProductType())){
            status = true;
        }
        return status;
	}
	
	public double totalValue (int productNumber) {
		double totalVal = productNumber * this.productValue;
		return totalVal;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public double getProductValue() {
		return productValue;
	}
	public void setProductValue(double productValue) {
		this.productValue = productValue;
	}
	
	
	
}
