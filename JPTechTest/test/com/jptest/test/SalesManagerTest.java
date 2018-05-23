package com.jptest.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.jptest.model.Product;
import com.jptest.model.Sale;
import com.jptest.model.SalesSum;
import com.jptest.sales.SalesManager;
import com.jptest.utils.CSVReader;

public class SalesManagerTest {

	@Test
	public void testSalesInfo() {
		String csvFile = "/com/jptest/resources/test.csv";
		CSVReader csvReader = new CSVReader();
		List<Sale> salesList = csvReader.processCSV(csvFile);
		
		List<Sale> salesListTest = new ArrayList<Sale>();
		Sale sale1 = new Sale();
		sale1.setAmount(20);
		Product product1 = new Product();
		product1.setProductName("apple");
		product1.setProductType("fruit");
		product1.setProductValue(8.5);
		sale1.setProduct(product1);
		salesListTest.add(sale1);
		Sale sale2 = new Sale();
		sale2.setAmount(15);
		Product product2 = new Product();
		product2.setProductName("banana");
		product2.setProductType("fruit");
		product2.setProductValue(6.5);
		sale2.setProduct(product2);
		salesListTest.add(sale2);
		Sale sale3 = new Sale();
		sale3.setAmount(13);
		Product product3 = new Product();
		product3.setProductName("tomatoe");
		product3.setProductType("vegetable");
		product3.setProductValue(7);
		sale3.setProduct(product3);
		salesListTest.add(sale3);
		Sale sale4 = new Sale();
		sale4.setAmount(10);
		Product product4 = new Product();
		product4.setProductName("potatoe");
		product4.setProductType("vegetable");
		product4.setProductValue(6);
		sale4.setProduct(product4);
		salesListTest.add(sale4);
		Sale sale5 = new Sale();
		sale5.setAmount(21);
		Product product5 = new Product();
		product5.setProductName("apple");
		product5.setProductType("fruit");
		product5.setProductValue(8.5);
		sale5.setProduct(product5);
		salesListTest.add(sale5);
		Sale sale6 = new Sale();
		sale6.setAmount(6);
		Product product6 = new Product();
		product6.setProductName("banana");
		product6.setProductType("fruit");
		product6.setProductValue(6.5);
		sale6.setProduct(product6);
		salesListTest.add(sale6);
		Sale sale7 = new Sale();
		sale7.setAmount(12);
		Product product7 = new Product();
		product7.setProductName("apple");
		product7.setProductType("fruit");
		product7.setProductValue(8.5);
		sale7.setProduct(product7);
		salesListTest.add(sale7);
		Sale sale8 = new Sale();
		sale8.setAmount(22);
		Product product8 = new Product();
		product8.setProductName("banana");
		product8.setProductType("fruit");
		product8.setProductValue(6.5);
		sale8.setProduct(product8);
		salesListTest.add(sale8);
		Sale sale9 = new Sale();
		sale9.setAmount(8);
		Product product9 = new Product();
		product9.setProductName("tomatoe");
		product9.setProductType("vegetable");
		product9.setProductValue(7);
		sale9.setProduct(product9);
		salesListTest.add(sale9);
		Sale sale10 = new Sale();
		sale10.setAmount(10);
		Product product10 = new Product();
		product10.setProductName("potatoe");
		product10.setProductType("vegetable");
		product10.setProductValue(6);
		sale10.setProduct(product10);
		salesListTest.add(sale10);
		/*assertTrue("Expected 'salesList' and 'salesListTest' to be equal."+
	            "\n  'salesList'        = "+salesList+
	            "\n  'salesListTest' = "+salesListTest, 
	            salesList.equals(salesListTest));*/
		 assertEquals(salesList, salesListTest);
	}

	@Test
	public void testUpdateSalesInfo() {
		String csvFile = "/com/jptest/resources/test.csv";
		CSVReader csvReader = new CSVReader();
		List<Sale> salesList = csvReader.processCSV(csvFile);
		
		List<Sale> updateSalesList = new ArrayList<>();
		List<SalesSum> salesSumList = new ArrayList<>();
		updateSalesList = new SalesManager().updateSalesInfo(salesList, "add", "apple", 2.5);
		updateSalesList = new SalesManager().updateSalesInfo(salesList, "substract", "banana", 1);
		salesSumList = new SalesManager().processAfterTen(updateSalesList, " AFTER ADJUSTMENT OPERATIONS");
		
		List<SalesSum> salesSumListTest = new ArrayList<>();
		SalesSum salesSum1 = new SalesSum();
		salesSum1.setProductAmount(53);
		salesSum1.setProductName("apple");
		salesSum1.setTotalPrice(583);
		salesSumListTest.add(salesSum1);
		SalesSum salesSum2 = new SalesSum();
		salesSum2.setProductAmount(43);
		salesSum2.setProductName("banana");
		salesSum2.setTotalPrice(236.5);
		salesSumListTest.add(salesSum2);
		SalesSum salesSum3 = new SalesSum();
		salesSum3.setProductAmount(20);
		salesSum3.setProductName("potatoe");
		salesSum3.setTotalPrice(120);
		salesSumListTest.add(salesSum3);
		SalesSum salesSum4 = new SalesSum();
		salesSum4.setProductAmount(21);
		salesSum4.setProductName("tomatoe");
		salesSum4.setTotalPrice(147);
		salesSumListTest.add(salesSum4);
		
		assertEquals(salesSumList, salesSumListTest);
	}

	@Test
	public void testProcessAfterTen() {
		String csvFile = "/com/jptest/resources/test.csv";
		CSVReader csvReader = new CSVReader();
		List<Sale> salesList = csvReader.processCSV(csvFile);
	
		List<SalesSum> salesSumList = new ArrayList<>();
		SalesManager salesManager = new SalesManager();
		salesSumList = salesManager.processAfterTen(salesList, "");
		
		List<SalesSum> salesSumListTest = new ArrayList<>();
		SalesSum salesSum1 = new SalesSum();
		salesSum1.setProductAmount(53);
		salesSum1.setProductName("apple");
		salesSum1.setTotalPrice(450.5);
		salesSumListTest.add(salesSum1);
		SalesSum salesSum2 = new SalesSum();
		salesSum2.setProductAmount(43);
		salesSum2.setProductName("banana");
		salesSum2.setTotalPrice(279.5);
		salesSumListTest.add(salesSum2);
		SalesSum salesSum3 = new SalesSum();
		salesSum3.setProductAmount(20);
		salesSum3.setProductName("potatoe");
		salesSum3.setTotalPrice(120);
		salesSumListTest.add(salesSum3);
		SalesSum salesSum4 = new SalesSum();
		salesSum4.setProductAmount(21);
		salesSum4.setProductName("tomatoe");
		salesSum4.setTotalPrice(147);
		salesSumListTest.add(salesSum4);
		
		assertEquals(salesSumList, salesSumListTest);
	}

}
