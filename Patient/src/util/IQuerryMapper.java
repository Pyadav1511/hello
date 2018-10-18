package util;

import bean.Patientbean;

public interface IQuerryMapper {
	
	
	public static final	String INSERT_Patient="INSERT INTO Patient11 values(p_seq.NEXTVAL,?,SYSDATE)";
	public static final	String EMP_SEQ_CURR_ID="SELECT p_seq.currval FROM dual";
	public static final	String RETRIEVE_BY_ID="SELECT * FROM Patient11 WHERE Patientid=?";
	public static final	String DELETE_BY_ID="DELETE FROM Patient11 WHERE emp_id=? ";
	//public static final String Retrieveall="select * from Patient11";
}
