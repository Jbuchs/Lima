package cpnv.jav1.lima;

import java.util.ArrayList;

import android.util.Log;

public class Article {
	private int _id;
	private String _name;
	private String _number;
	private String _supplier;
	private double _price;
	private double _TVA;
	private int _stock;
	private boolean _obsolete;

	public static final String sqlId = "idarticle";
	public static final String sqlName = "articlename";
	public static final String sqlNumber = "articlenumber";
	public static final String sqlSupplier = "supplier";
	public static final String sqlPrice = "price";
	public static final String sqlTVA = "TVA";
	public static final String sqlStock = "stock";
	public static final String sqlObsolete = "obsolete";
	public static final String sqlTable = "article";
	public static final String dao = "http://192.168.0.4/";

	public Article() {}
	
	public Article(String name, String number, String supplier, double price,
			double tVA, int stock, boolean obsolete) {
		setName(name);
		setNumber(number);
		setObsolete(obsolete);
		setPrice(price);
		setStock(stock);
		setSupplier(supplier);
		setTVA(tVA);
		
		//this.save();
	}
	
	public String dump() {
		return "name : " + _name + ", number : " + _number + ", supplier : " + _supplier;
	}

	public int getId() {
		return _id;
	}

	public void setId(int id) {
		_id = id;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getNumber() {
		return _number;
	}

	public void setNumber(String number) {
		_number = number;
	}

	public String getSupplier() {
		return _supplier;
	}

	public void setSupplier(String supplier) {
		_supplier = supplier;
	}

	public double getPrice() {
		return _price;
	}

	public void setPrice(double price) {
		_price = price;
	}

	public double getTVA() {
		return _TVA;
	}

	public void setTVA(double tVA) {
		_TVA = tVA;
	}

	public int getStock() {
		return _stock;
	}

	public void setStock(int stock) {
		_stock = stock;
	}

	public boolean getObsolete() {
		return _obsolete;
	}

	public void setObsolete(boolean obsolete) {
		_obsolete = obsolete;
	}

}
