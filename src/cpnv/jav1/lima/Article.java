package cpnv.jav1.lima;

import java.lang.reflect.Field;

public class Article {

	// CPNV Article for the Lima App
	// Author:	X. Carrel
	// Date: May 2014
	
	private String _name;
	private String _number; // CPNV Article number
	private String _supplier;
	private double _price;
	private double _VAT; // = swiss "TVA"
	private int _stock;
	private boolean _obsolete;
	
	// ================================== Constructors ==========================================
	
	public Article ()
	// Default constructor
	{
		_name = "(à définir)";
		_number = "0";
		_supplier = "(à définir)";
		_price = 0.0;
		_VAT = 0.0;
		_stock = 0;
		_obsolete = false;
	}
	
	/**
	 * 
	 * @param name
	 * @param number
	 * @param resp
	 * @param supplier
	 * @param price
	 * @param VAT
	 */
	public Article (String name, String number, String supplier, double price, double VAT, int stock, boolean obsolete)
	{
		if (name.length() < 3) // All names must be at least 3 characters long
			_name = "(à définir)";
		else
			_name = name;
		
		_number = number;
		
		if (supplier.length() < 3) // All names must be at least 3 characters long
			_supplier = "(à définir)";
		else
			_supplier = supplier;
		
		if (price < 0.0)
			_price = 0;
		else
			_price = price;

		if (VAT < 0.0)
			_VAT = 0;
		else
			_VAT = VAT;
		
		_stock = stock;
		_obsolete = obsolete;
	}
	
	// Duplication constructor
	public Article (Article original)
	{
		_name = original.getName();
		_number = "tbd";
		_supplier = original.getSupplier();
		_price = original.getPrice();
		_VAT = original.getVAT();
		_stock = 0;
		_obsolete = original.isObsolete();
	}
	
	// ================================== Getter / Setter ==========================================
	
	public String getName() {
		return _name;
	}

	public void setName(String name) {
		if (name.length() < 3) // All names must be at least 3 characters long
			_name = "(à définir)";
		else
			_name = name;
	}

	public String getNumber()
	{
		return _number;
	}

	public String getSupplier() {
		return _supplier;
	}

	public void setSupplier(String supplier) {
		if (supplier.length() < 3) // All names must be at least 3 characters long
			_supplier = "(à définir)";
		else
			_supplier = supplier;
	}

	public double getPrice() {
		return _price;
	}

	public void setPrice(double price) {
		if (price < 0.0) // All numbers must be positive
			_price = 0;
		else
			_price = price;
	}

	public double getVAT() {
		return _VAT;
	}

	public void setVAT(double VAT) {
		if (VAT < 0.0) // All numbers must be positive
			_VAT = 0;
		else
			_VAT = VAT;
	}
	
	public int getStock() {
		return _stock;
	}

	public void setStock(int stock) {
		_stock = stock;
	}

	public boolean isObsolete() {
		return _obsolete;
	}

	public void setObsolete(boolean obsolete) {
		_obsolete = obsolete;
	}

	public void setNumber(String number) {
		_number = number;
	}


	// ================================== Other public methods ==========================================
	
	public String dump()
	// Dumps content according to requested format
	{
		return _name+"-"+_number+"-"+_supplier+"-"+_price+"-"+_VAT;
	}
}
