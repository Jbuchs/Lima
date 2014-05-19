package cpnv.jav1.lima;

import java.util.Date;

/**
*@author Joel.BUCHS
*@author Olivier.NICOLE
*/
public abstract class Log {
	int _id;
	int _fk_person;
	Date _timestamp;
	String _message;
	int _type;
	
	/**
	 *
	 * @param
	 */
	protected Log(int fk_person, String message, int type){
		//To do, add ID and add timestamp
		
		set_fk_person(fk_person);
		set_message(message);
		set_type(type);
	}
	
	/**
	 *
	 * @return _id
	 */
	public int get_id() {
		return _id;
	}
	
	/**
	 *
	 * @param _id
	 */
	public void set_id(int _id) {
		this._id = _id;
	}
	
	/**
	 *
	 * @return _fk_person
	 */
	public int get_fk_person() {
		return _fk_person;
	}
	
	/**
	 *
	 * @param _fk_person
	 */
	public void set_fk_person(int _fk_person) {
		this._fk_person = _fk_person;
	}
	
	/**
	 *
	 * @return _timestamp
	 */
	public Date get_timestamp() {
		return _timestamp;
	}
	
	/**
	 *
	 * @param _timestamp
	 */
	public void set_timestamp(Date _timestamp) {
		this._timestamp = _timestamp;
	}
	
	/**
	 *
	 * @return _message
	 */
	public String get_message() {
		return _message;
	}
	
	/**
	 *
	 * @param _message
	 */
	public void set_message(String _message) {
		this._message = _message;
	}
	
	/**
	 *
	 * @return _type
	 */
	public int get_type() {
		return _type;
	}

	/**
	 *
	 * @param _message
	 */
	public void set_type(int type) {
		this._type = type;
	}
}
