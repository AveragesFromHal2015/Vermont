package jp.ac.hal.Beans;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;

<<<<<<< HEAD
public class Cart{
	
	private ArrayList<String> productList;
=======
public class Cart {

	private ArrayList<Product> productList;
>>>>>>> 1d7c38ce0c0e9725edeb0d470e175163ac6cacba
	private Date date;

	public Cart() {
		this.productList = new ArrayList<String>();
		this.date = new Date();
	}
<<<<<<< HEAD
	
	public void addCart(String...products) {
=======

	public void addCart(Product... products) {
>>>>>>> 1d7c38ce0c0e9725edeb0d470e175163ac6cacba
		for (int i = 0; i < products.length; i++) {
			productList.add(products[i]);
		}
	}
<<<<<<< HEAD
	
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
=======

	// cartから消す処理
	public void deleteProduct(Product... products) {
		for (int i = 0; i < products.length; i++) {
			productList.remove(products[i]);
		}
	}

	public ArrayList<Product> getAllCart() {
		return productList;
	}

	public void setProducts(ArrayList<Product> product) {
>>>>>>> 1d7c38ce0c0e9725edeb0d470e175163ac6cacba
		this.productList = product;
	}

	// クッキーにセット
	public void setCookie() {

	}

}
