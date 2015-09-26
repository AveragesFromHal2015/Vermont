package jp.ac.hal.Beans;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;

public class Cart{
	
	private ArrayList<Product> product;
	private Date date;
	
	public Cart(ArrayList<Product> product) {
		this.product = product;
		this.date = new Date();
	}
	
	public void addCart(Product...products) {
		for (int i = 0; i < products.length; i++) {
			product.add(products[i]);
		}
	}
	
	//cartから消す処理
	
	public ArrayList<Product> getAllCart() {
		return product;
	}
	
	//クッキーにセット
	public void setCookie() {
		
	}
	
	
}
