package cpnv.jav1.lima;

import java.util.Comparator;

public class Gear extends Article {

	// CPNV Gear for the Lima App
	// Author:	X. Carrel
	// Date: May 2014

	private String _size; // XS, S, M, L, XL, XXL
	
	// ================================== Constructors ==========================================
	
	// Default constructor
	public Gear() {
		super();
		_size = "U"; // Default value "Unique"
	}
	
	public Gear(String name, String number, String supplier, double price, double VAT, int stock, boolean obsolete, String size) {
		super (name, number, supplier, price, VAT, stock, obsolete);
		if ((size.length() > 3) || (size.length() < 1)) // Invalid size code
			_size = "U"; // Default value "Unique"
		else
			_size = size;
	}
	
	public Gear(Gear original){
		super((Article)original);
		_size = original.getSize();
	}

	// ================================== Getter / Setter ==========================================
	
	public String getSize() {
		return _size;
	}

	public void setSize(String size) {
		if ((size.length() > 3) || (size.length() < 1)) // Invalid size code
			_size = "U"; // Default value "Unique"
		else
			_size = size;
	}

	// ================================== Other public methods ==========================================
	
	public String dump() {
		return super.dump()+"-"+_size;
	}

	public int compareTo (Gear other) {
		switch (this.getName().compareTo(other.getName()))
		{
		case 0: // same name: drill down to the size
			// Rank of lhs's size
			int thisSizeRank = 10; // undefined / unrecognized sizes go to the end
			String s = this.getSize();
			
			if (s.equals("XS")) thisSizeRank = 1;
			if (s.equals("S")) thisSizeRank = 2;
			if (s.equals("M")) thisSizeRank = 3;
			if (s.equals("L")) thisSizeRank = 4;
			if (s.equals("XL")) thisSizeRank = 5;
			if (s.equals("XXL")) thisSizeRank = 6;
			
			// switch would have been cleaner, but isn't supported on string by JRE < 1.7
			// and I don't want to install a JRE just for that
			
			// Rank of lhs's size
			int otherSizeRank = 10; // undefined / unrecognized sizes go to the end
			s = other.getSize();
			if (s.equals("XS")) otherSizeRank = 1;
			if (s.equals("S")) otherSizeRank = 2;
			if (s.equals("M")) otherSizeRank = 3;
			if (s.equals("L")) otherSizeRank = 4;
			if (s.equals("XL")) otherSizeRank = 5;
			if (s.equals("XXL")) otherSizeRank = 6;
			
			if (thisSizeRank == otherSizeRank)
				return 0;
			else
				if (thisSizeRank > otherSizeRank)
					return 1;
				else
					return -1;
			
		case 1: return 1;
		case -1: return -1;
		}
		return 0;
	}

}
