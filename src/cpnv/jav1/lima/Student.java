package cpnv.jav1.lima;

import java.util.Date;

public class Student extends Person {

	private int _startYear;
	
	public int getStartYear() {
		return _startYear;
	}

	public void setStartYear(int startYear) throws Exception {
		if (startYear > 2000)
			_startYear = startYear;
		else
			throw new Exception("Invalid start Year");
	}

	public Student(String firstname, String lastname, int startYear) throws Exception {
		super(firstname, lastname);
		if (startYear > 2000)
			_startYear = startYear;
		else
			throw new Exception("Invalid start Year");
	}

	@Override
	public void setBirthDate(Date birthDate) throws Exception 
	{
		if ((new Date()).getYear() - birthDate.getYear() >= 15)
			_birthDate = birthDate;
		else
			throw new Exception("Too young to be a student");
	}

	@Override
	public String dump()
	{
		return super.dump()+" (volée "+_startYear + ")";
	}
}
