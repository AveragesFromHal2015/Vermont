package jp.ac.hal.Beans;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Product {
	int productid;
	String productname;
	int price;
	int orderpoint;
	String orderdate;
	int orderamount;
	int stock;
	String registration;
	int maker;
	int categoryid;
	String description;
	String categoryname;



	public Product(int productid, String productname, int price, int orderpoint, String orderdate,
			int orderamount, int stock, String registration, int categoryid, int maker, String description) {
		this.productid = productid;
		this.productname = productname;
		this.price = price;
		this.orderpoint = orderpoint;
		this.orderdate = orderdate;
		this.orderamount = orderamount;
		this.stock = stock;
		this.registration = registration;
		this.categoryid = categoryid;
		this.maker = maker;
		this.description = description;

	}
	public Product(int productid, String productname, int price, int stock, String categoryname) {
		this.productid = productid;
		this.productname = productname;
		this.price = price;
		this.stock = stock;
		this.categoryname = categoryname;
	}
	public Product(int productid, String productname, int price) {
		this.productid = productid;
		this.productname = productname;
		this.price = price;
	}
	public void setMaker(int maker) {
		this.maker = maker;
	}
	public void setCategory(int categoryid) {
		this.categoryid = categoryid;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setOrderdate(Date orderdate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		this.orderdate = sdf.format(orderdate);
	}
	public void setRegistration(Date registration) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		this.registration = sdf.format(registration);
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setOrderpoint(int orderpoint) {
		this.orderpoint = orderpoint;
	}
	public void setOrderamount(int orderamount) {
		this.orderamount = orderamount;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getProductid() {
		return productid;
	}
	public String getProductname() {
		return productname;
	}
	public int getPrice() {
		return price;
	}
	public int getOrderpoint() {
		return orderpoint;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public int getOrderamount() {
		return orderamount;
	}
	public int getStock() {
		return stock;
	}
	public String getRegistration() {
		return registration;
	}
	public int getCategoryid() {
		return categoryid;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	public void setRegistration(String registration) {
		this.registration = registration;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public int getMaker() {
		return maker;
	}
	public String getDescription() {
		return description;
	}

}
