package cpnv.jav1.lima;

import java.util.ArrayList;

import android.util.Log;

public class Article {
	private int _id;
	private String _name;
	private String _number;
	private String _supplier;
	private float _price;
	private float _TVA;
	private int _stock;
	private int _obsolete;

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
	
	public Article(int id) {
		_id = id;
		LimaDb dao = new LimaDb(this.dao);
		int rep = dao.executeQuery("SELECT * FROM " + sqlTable + " WHERE idarticle = "
				+ _id);
		if (rep != 1) {
			// throw new Exception("Aucun article trouvé");
		}
		Log.i("LIMA", String.valueOf(rep));
		while (dao.moveNext()) {
			_name = dao.getField(sqlName);
			_number = dao.getField(sqlNumber);
			_supplier = dao.getField(sqlSupplier);
			_price = Float.parseFloat(dao.getField(sqlPrice));
			_TVA = Float.parseFloat(dao.getField(sqlTVA));
			_stock = Integer.parseInt(dao.getField(sqlStock));
			_obsolete = Integer.parseInt(dao.getField(sqlObsolete));
		}
	}

	public Article(String name, String number, String supplier, float price,
			float tVA, int stock, int obsolete) {
		setName(name);
		setNumber(number);
		setObsolete(obsolete);
		setPrice(price);
		setStock(stock);
		setSupplier(supplier);
		setTVA(tVA);
		
		//this.save();
	}
	
	public static ArrayList<Article> list() {
		ArrayList<Article> list = new ArrayList<Article>();
		LimaDb dao = new LimaDb("http://192.168.0.4/");
		int rep = dao.executeQuery("SELECT * FROM " + sqlTable);
		if (rep < 1) {
			// throw new Exception("Aucun article trouvé");
		}
		while (dao.moveNext()) {
			Article article = new Article(
					dao.getField(sqlName), 
					dao.getField(sqlNumber), 
					dao.getField(sqlSupplier), 
					Float.parseFloat(dao.getField(sqlPrice)), 
					Float.parseFloat(dao.getField(sqlTVA)),
					Integer.parseInt(dao.getField(sqlStock)),
					Integer.parseInt(dao.getField(sqlObsolete)));
			list.add(article);
		}
		return list;
	}
	
	private boolean save(){
		LimaDb dao = new LimaDb(this.dao);
		String sql = "INSERT INTO " + sqlTable + " ("
				+ sqlName + ","
				+ sqlNumber + ","
				+ sqlSupplier + ","
				+ sqlPrice + ","
				+ sqlTVA + ","
				+ sqlStock + ","
				+ sqlObsolete + ") VALUES ('"
				+ _name + "','"
				+ _number + "','"
				+ _supplier + "',"
				+ _price + ","
				+ _TVA + ","
				+ _stock + ","
				+ _obsolete + ")";
		int rep = dao.executeQuery(sql);
		Log.i("LIMA", sql);
		Log.i("LIMA", Integer.toString(rep));
		return false;
	}

	public String dump() {
		return "id : " + _id + "\n name : " + _name + "\n number : " + _number
				+ "\n supplier : " + _supplier + "\n price : " + _price
				+ "\n TVA : " + _TVA + "\n stock : " + _stock
				+ "\n obsolete : " + _obsolete;
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

	public void setPrice(float price) {
		_price = price;
	}

	public float getTVA() {
		return _TVA;
	}

	public void setTVA(float tVA) {
		_TVA = tVA;
	}

	public int getStock() {
		return _stock;
	}

	public void setStock(int stock) {
		_stock = stock;
	}

	public int getObsolete() {
		return _obsolete;
	}

	public void setObsolete(int obsolete) {
		_obsolete = obsolete;
	}

}
