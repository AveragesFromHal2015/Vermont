package jp.ac.hal.Beans;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;

public class Cart{
	
	private ArrayList<String> productList;
	private Date date;
	
	public Cart() {
		this.productList = new ArrayList<String>();
		this.date = new Date();
	}
	
	public void addCart(String...products) {
		for (int i = 0; i < products.length; i++) {
			productList.add(products[i]);
		}
	}
	
	//cartから消す処理
	public void deleteProduct(String...products) {
		for(int i = 0; i < products.length; i++){
			productList.remove(products[i]);
		}
	}	
	
	public ArrayList<String> getAllCart() {
		return productList;
	}
	
	public void setProducts(ArrayList<String> product) {
		this.productList = product;
	}
	
	//クッキーにセット
	public void setCookie() {
		
	}
	
}
