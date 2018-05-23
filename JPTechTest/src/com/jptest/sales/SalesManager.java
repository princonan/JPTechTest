package com.jptest.sales;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.jptest.model.Sale;
import com.jptest.model.SalesSum;
import com.jptest.utils.CSVReader;
import static java.util.stream.Collectors.toList;

public class SalesManager {
	

	public static void main(String[] args) {
		System.out.println("        PRODUCT     PRICE     AMOUNT");
		List<Sale> salesList = new SalesManager().salesInfo();
		for(int i = 0; i<salesList.size(); i++) {
			
			System.out.println("SALE " + (i+1)+" - "+salesList.get(i).getProduct().getProductName()
					+"     "+salesList.get(i).getProduct().getProductValue()
					+"     "+salesList.get(i).getAmount()
					);
			if((i+1)% 10 == 0) {
				new SalesManager().processAfterTen(salesList.subList(0, i), "AFTER " +(i+1)+" SALES........");
			}
			if(i==49) {
				System.out.println("PAUSING APPLICTION AFTER 50 sales...");
				break;
			}
		}
		List<Sale> updateSalesList = new ArrayList<>();
		updateSalesList = new SalesManager().updateSalesInfo(salesList, "add", "apple", 2.5);
		updateSalesList = new SalesManager().updateSalesInfo(salesList, "substract", "banana", 1);
		new SalesManager().processAfterTen(updateSalesList, " AFTER ADJUSTMENT OPERATIONS");
	}
	
	public List<Sale> salesInfo(){
		String csvFile = "/com/jptest/resources/sales.csv";
		CSVReader csvReader = new CSVReader();
		List<Sale> salesList = csvReader.processCSV(csvFile);
		return salesList;
	}
	
	public List<Sale> updateSalesInfo(List<Sale> saleList, String operation, String productName, double plus){

		for(Sale sale : saleList) {
			if(sale.getProduct().getProductName().equals(productName)) {
				double totalPrice = 0.0;
				if(operation.equals("add")) {
					totalPrice = sale.getProduct().getProductValue()+plus;
				}else if(operation.equals("substract")) {
					totalPrice = sale.getProduct().getProductValue()-plus;
				}else if(operation.equals("multiply")) {
					totalPrice = sale.getProduct().getProductValue()*plus;
				}
				sale.getProduct().setProductValue(totalPrice);
			}
		}
		return saleList;
	}
	
	public List<SalesSum> processAfterTen(List<Sale> salesList, String headMessage){
		List<SalesSum> salesSumList = new ArrayList<>();
		List<Sale> salesListOrdered = salesList.stream().collect(toList());
		Collections.sort(salesListOrdered, new Comparator<Sale>(){
		     public int compare(Sale s1, Sale s2){
		         return s1.getProduct().getProductName().compareTo(s2.getProduct().getProductName());
		     }
		});
		for(Sale sale : salesListOrdered) {
			SalesSum saleSum = new SalesSum();
			if(salesSumList.size()>0 && sale.getProduct().getProductName().equals(salesSumList.get(salesSumList.size()-1).getProductName())) {
				saleSum = salesSumList.get(salesSumList.size()-1);
				saleSum.setProductAmount(saleSum.getProductAmount() + sale.getAmount());
				saleSum.setTotalPrice(saleSum.getTotalPrice() + sale.getAmount()*sale.getProduct().getProductValue());
			}else {
				saleSum.setProductName(sale.getProduct().getProductName());
				saleSum.setProductAmount(sale.getAmount());
				saleSum.setTotalPrice(sale.getAmount()*sale.getProduct().getProductValue());
				salesSumList.add(saleSum);
			}
		}
		printSales(salesSumList, headMessage);
		return salesSumList;
	}
	
	public void printSales(List<SalesSum> salesSumList, String headMessage) {
		System.out.println("****************************************");
		System.out.println(headMessage);
		double totalPrice = 0.0;
		for(SalesSum saleSum : salesSumList) {
			totalPrice += saleSum.getTotalPrice();
			System.out.println("PRODUCT=" + saleSum.getProductName() + " AMOUNT="+saleSum.getProductAmount()+ " PRICE="+saleSum.getTotalPrice());
		}
		System.out.println("TOTAL PRICE="+totalPrice);
		System.out.println("****************************************");
	}
	

}
