package cpnv.jav1.lima;

import java.util.Date;

public class Student extends Person {

	private int _startYear;
	
	public int getStartYear() {
		return _startYear;
	}

	public void setStartYear(int startYear) throws LimaException {
		if (startYear > 2000)
			_startYear = startYear;
		else
			throw new LimaException("Invalid start Year");
	}

	/**
	 * Constructor
	 * @param firstname
	 * @param lastname
	 * @param startYear
	 * @throws LimaException
	 */
	public Student(String firstname, String lastname, Date bdate, int startYear) throws LimaException {
		super(firstname, lastname);
		setBirthDate(bdate);
		if (startYear > 2000)
			_startYear = startYear;
		else
			throw new LimaException("Invalid start Year");
	}

	@Override
	public void setBirthDate(Date birthDate) throws LimaException 
	{
		if (getYearsSince(birthDate) >= 15)
			_birthDate = birthDate;
		else
			throw new LimaException("Too young to be a student");
	}

	@Override
	public String dump()
	{
		return super.dump()+" (volée "+_startYear + ")";
	}
}
