package dao;

import exception.PatientException;
import bean.Patientbean;

public interface Idao {
	
	int addPatient(Patientbean p) throws PatientException;
	public Patientbean getpatientDetails(int PatientId) throws PatientException;
	public String updatePatient(int id, String name1)throws PatientException;
	  public Patientbean retrieveById(int searchId) throws PatientException;
	public int deleteById(int pId)throws PatientException;

}