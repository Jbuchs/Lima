package cpnv.jav1.lima;

/**
*
*@author Olivier.NICOLE
*/
public class AppLog extends Log{
	
	protected AppLog(int fk_person, String message, int type){
		super(fk_person, message, type);
	}
}
