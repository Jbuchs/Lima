package cpnv.jav1.lima;

import java.util.Date;

public class Teacher extends Person 
{
	private String _domain;
	
	public String getStartYear() {
		return _domain;
	}

	public void setStartYear(String domain) throws Exception {
		if (domain.length() > 2)
			_domain = domain;
		else
			throw new Exception("Invalid domain");
	}

	/**
	 * 
	 * @param firstname
	 * @param lastname
	 * @param domain
	 * @throws Exception
	 */
	public Teacher(String firstname, String lastname, String domain) throws Exception {
		super(firstname, lastname);
		if (domain.length() > 2)
			_domain = domain;
		else
			throw new Exception("Invalid domain");
	}

	@Override
	public void setBirthDate(Date birthDate) throws Exception 
	{
		if ((new Date()).getYear() - birthDate.getYear() >= 25)
			_birthDate = birthDate;
		else
			throw new Exception("Too young to be a teacher");
	}

	@Override
	public String dump()
	{
		return super.dump()+" (enseigne en "+_domain + ")";
	}
}
