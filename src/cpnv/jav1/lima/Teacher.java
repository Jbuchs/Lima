package cpnv.jav1.lima;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Teacher extends Person 
{
	protected String _domain;
	
	public String getDomain() {
		return _domain;
	}

	public void setDomain(String domain) throws LimaException {
		if (domain.length() > 2)
			_domain = domain;
		else
			throw new LimaException("Invalid domain");
	}

	/**
	 * Main constructor
	 * @param firstname
	 * @param lastname
	 * @param domain
	 * @throws Exception
	 */
	public Teacher(String firstname, String lastname, Date bdate, String domain) throws LimaException {
		super(firstname, lastname);
		setBirthDate(bdate);
		if (domain.length() > 2)
			_domain = domain;
		else
			throw new LimaException("Invalid domain");
	}

	@Override
	public final void setBirthDate(Date birthDate) throws LimaException 
	{
		if (getYearsSince(birthDate) >= 25)
			_birthDate = birthDate;
		else
			throw new LimaException("Too young to be a teacher");
	}

	@Override
	public String dump()
	{
		return super.dump()+" (enseigne en "+_domain + ")";
	}
}
