package cpnv.jav1.lima;

import java.util.Date;

/**
 * Lima Exceptions capture the date/time of the exception occurrence
 * 
 * @author Xavier
 *
 */
public class LimaException extends Exception{

	/**
	 * The date/time when the exception occurred
	 */
	private Date _moment;

	/**
	 * Default constructor
	 */
	public LimaException()
	{
		super();
		_moment = new Date(); // current date 
	}
	
	/**
	 * Constructor with message
	 * @param msg
	 * The exception's message
	 */
	public LimaException(String msg)
	{
		super(msg);
		_moment = new Date(); // current date 
	}

	/**
	 * Moment getter
	 * @return
	 * Date/time of the exception
	 */
	public Date getMoment() {
		return _moment;
	}
	
	
}
