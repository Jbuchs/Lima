package cpnv.jav1.lima;

public class Gear extends Article{

	// Initialization variable size
	private String _size;

	// Constructor
	public Gear(){
		super();
		_size = "Undefined";
	}
	public Gear(String name, String number, String supplier, double price, double VAT, int stock, boolean obs, String size) {
		super(name, number, supplier, price, VAT, stock, obs);
		if ((size.length() > 3) || (size.length() < 1))
			_size = "Undefined";
		else
			_size = size;
	}
	//Setter
	public String getSize(){
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
		return super.dump()+", size : "+_size;
	}
	
	/**
	 * Compare this gear object to another.
	 * The comparison order is: 
	 *   - Alphabetically on the name
	 *   - On the size (XS,S,M,L,XL,XXL)
	 *   - Alphabetically on the supplier name
	 * @param other
	 * The other Gear to which we compare this object
	 * @return
	 * 1 if 'this' is greater than 'other'
	 * 0 if 'this' is equal to 'other'
	 * -1 if 'this' is smaller than 'other'
	 */
	public int compareTo (Gear other) {
		int cmps = this.getName().compareTo(other.getName());
		if (cmps == 0) // same name: drill down to the size
		{
			// Rank of this's size
			int thisSizeRank = 0; // undefined / unrecognized sizes go to the end
			String s = this.getSize();
			
			if (s.equals("XS")) thisSizeRank = 1;
			if (s.equals("S")) thisSizeRank = 2;
			if (s.equals("M")) thisSizeRank = 3;
			if (s.equals("L")) thisSizeRank = 4;
			if (s.equals("XL")) thisSizeRank = 5;
			if (s.equals("XXL")) thisSizeRank = 6;
			
			// switch would have been cleaner, but isn't supported on string by JRE < 1.7
			// and I don't want to install a JRE just for that
			
			// Rank of other's size
			int otherSizeRank = 0; // undefined / unrecognized sizes go to the end
			s = other.getSize();
			if (s.equals("XS")) otherSizeRank = 1;
			if (s.equals("S")) otherSizeRank = 2;
			if (s.equals("M")) otherSizeRank = 3;
			if (s.equals("L")) otherSizeRank = 4;
			if (s.equals("XL")) otherSizeRank = 5;
			if (s.equals("XXL")) otherSizeRank = 6;
			
			if (thisSizeRank == otherSizeRank) // Same size -> use supplier name
			{
				cmps = this.getSupplier().compareTo(other.getSupplier());
				if (cmps == 0) return 0;// Same supplier -> no difference found
				if (cmps > 0) return 1; // Supplier of other is bigger
				if (cmps < 0) return -1;// Supplier of other is smaller
			}
			else
				if (thisSizeRank > otherSizeRank)
					return 1;
				else
					return -1;
		}
		if (cmps > 0) return 1; // Name of other is bigger
		if (cmps < 0) return -1;// Name of other is smaller
		return 0; // unreachable. just to keep the compiler happy
	}

}