package cpnv.jav1.lima;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Abstract class modeling a person
 * 
 * @author Xavier
 *
 */
public abstract class Person {

	private String _firstname;
	private String _lastname;
	protected Date _birthDate;

	/**
	 * Constructor
	 * @param firstname
	 * @param lastname
	 * @throws Exception
	 * If the firstname or the lastname is less than 2 characters long
	 */
	public Person(String firstname, String lastname) throws Exception
	{
		if (firstname.length() > 1)
			_firstname = firstname;
		else
			throw new Exception("Firstname too short");		
		if (lastname.length() > 1)
			_lastname = lastname;
		else
			throw new Exception("lastname too short");		
	}
	
	//
	public String getFirstname() {
		return _firstname;
	}
	public void setFirstname(String firstname) throws Exception {
		if (firstname.length() > 1)
			_firstname = firstname;
		else
			throw new Exception("Nom trop court");
	}
	public String getLastname() {
		return _lastname;
	}
	public void setLastname(String lastname) {
		_lastname = lastname;
	}
	public Date getBirthDate() {
		return _birthDate;
	}
	
	// setBirthdate is pure virtual
	public abstract void setBirthDate(Date birthDate) throws Exception;
	
	public String dump()
	{
		return _firstname.substring(0,1).toUpperCase()+_firstname.substring(1).toLowerCase()+" "+_lastname.toUpperCase();
	}
	
	protected int getYearsBetween(Date date1,Date date2)
	{ 
		SimpleDateFormat simpleDateformat=new SimpleDateFormat("yyyy");
		Integer.parseInt(simpleDateformat.format(date1));
		return Integer.parseInt(simpleDateformat.format(date2))- Integer.parseInt(simpleDateformat.format(date1));
	}
	
}
