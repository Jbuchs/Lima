//	File 		: Class Gear
// 	Version		: 1.0
//	Author 		: Fabien Languetin
//	Project 	: Lima 

package cpnv.jav1.lima;

import linkedlist.EmptyListException;

public class Gear extends Article{

	// Initialization variable size
	private String _size;
	
	// Constructor
	public Gear(){
		super();
		_size = "Undefined";
	}
	public Gear(String name, int number, String resp, String supplier, double price, double VAT, String size) {
		super (name, number, resp, supplier, price, VAT);
		if ((size.length() > 3) || (size.length() < 1)) // Invalid size code
			_size = "Undefined"; // Default value "Unique"
		else
			_size = size;
	}
	//Setter
	public String getGear(){
		return this._size;
	}
	public void setSize(String size) {
		if ((size.length() > 3) || (size.length() < 1)) // Invalid size code
			_size = "Undefined"; // Default value "Unique"
		else
			_size = size;
	}
	
	// Methodes
	public String dump() {
		return super.dump()+" : "+_size;
	}
}
