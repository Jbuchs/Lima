package cpnv.jav1.lima;

public class Gear extends Article{

	// Initialization variable size
	private String _size;

	// Constructor
	public Gear(){
		super();
		_size = "Undefined";
	}
	public Gear(String name, String number, String supplier, float price, float VAT, int stock, int obs, String size) {
		super(name, number, supplier, price, VAT, stock, obs);
		if ((size.length() > 3) || (size.length() < 1))
			_size = "Undefined";
		else
			_size = size;
	}
	//Setter
	public String getGear(){
		return this._size;
	}
	public void setSize(String size) {
		if ((size.length() > 3) || (size.length() < 1))
			_size = "Undefined";
		else
			_size = size;
	}

	// Methodes
	public String dump() {
		return super.dump()+" : "+_size;
	}
}