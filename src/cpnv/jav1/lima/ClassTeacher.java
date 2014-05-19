package cpnv.jav1.lima;

public class ClassTeacher extends Teacher {

	private String _className;
	
	public String getClassName() {
		return _className;
	}

	public void setClassName(String cname) {
		_className = cname;
	}

	/**
	 * Only constructor: copy of an existing teacher, with a class name
	 * @param t
	 * Teacher object serving as base
	 * @param cname
	 * Class name
	 * @throws LimaException
	 * If the classname is invalid
	 */
	public ClassTeacher(Teacher t, String cname)
			throws LimaException {

		super(t.getFirstname(),t.getLastname(),t.getBirthDate(),t.getDomain());
		
		if (cname.length() < 2)
			throw new LimaException("Invalid class name");
		else
			_className = cname;
	}
	
	// public void setBirthDate(Date birthDate) throws LimaException 


}
