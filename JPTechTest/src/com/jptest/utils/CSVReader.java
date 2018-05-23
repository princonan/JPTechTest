package com.jptest.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.jptest.model.Product;
import com.jptest.model.Sale;

public class CSVReader {

	
	public List<Sale> processCSV(String path) {
		List<Sale> salesList = new ArrayList<Sale>();
	    BufferedReader br = null;
	    String line = "";
	    String cvsSplitBy = ",";
	
	    try {
	    	InputStream streamCsv = CSVReader.class.getResourceAsStream(path);
	        br = new BufferedReader(new InputStreamReader(streamCsv));
	        while ((line = br.readLine()) != null) {
	
	            // use comma as separator
	            String[] csvVals = line.split(cvsSplitBy);
	            Product product = new Product();
	            product.setProductName(csvVals[0]);
	            product.setProductValue(Double.parseDouble(csvVals[1]));
	            product.setProductType(csvVals[2]);
	            Sale sale = new Sale();
	            sale.setAmount(Integer.parseInt(csvVals[3]));
	            sale.setProduct(product);
	            
	            salesList.add(sale);
	
	        }
	
	    } catch (FileNotFoundException e) {
	    	 System.out.println(" There file was not found. " + e.getMessage());
	    } catch (IOException e) {
	    	 System.out.println(" There was an Error Reading the file. " + e.getMessage());
		}
		return salesList;

	}
	
}
