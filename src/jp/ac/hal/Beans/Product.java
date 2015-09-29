package src.jp.ac.hal.Beans;

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



	public Product(int productid, String productname, int price, int stock) {
		// TODO 自動生成されたコンストラクター・スタブ
		super();
		this.productid = productid;
		this.productname = productname;
		this.price = price;
		this.stock = stock;
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
	public void setOrderdate(Date OrderDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		this.orderdate = sdf.format(OrderDate);
	}
	public void setOrderamount(int orderamount) {
		this.orderamount = orderamount;
	}
	public void setStack(int stock) {
		this.stock = stock;
	}
	public void setRegistration(Date Registration) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		this.registration = sdf.format(Registration);
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
	public int getStack() {
		return stock;
	}
	public String getRegistration() {
		return registration;
	}
}
