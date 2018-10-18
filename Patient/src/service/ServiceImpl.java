package service;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.DaoImpl;
import dao.Idao;
import exception.PatientException;
import bean.Patientbean;

public class ServiceImpl implements Iservice {
Idao idao=null;
	@Override
	public int addPatient(Patientbean p) throws PatientException{
	idao=new DaoImpl();
	int eid=idao.addPatient(p);
	return eid;
}
	@Override
	public boolean validateName(String name) {
		String s="[A-Z][a-z]{1,}";
		Pattern p=Pattern.compile(s);
		Matcher m=p.matcher(name);
		if(m.find())
		{
			return true;
		}
		else{
		return false;}
	}
	@Override
	public Patientbean getpatientDetails(int PatientId) throws PatientException {
		idao=new DaoImpl();
		return idao.getpatientDetails(PatientId);
	}
	/*@Override
	public ArrayList<Patientbean> retrieveAll() throws PatientException {
		idao=new DaoImpl();
		return idao.retrieveAll();
	}*/
	@Override
	public String updatePatient(int Patientid, String PatientName) throws PatientException {
		idao=new DaoImpl();
		return idao.updatePatient(Patientid, PatientName);
	}
	@Override
	public Patientbean retrieveById(int searchId) throws PatientException {
		
		idao=new DaoImpl();
	return idao.retrieveById(searchId);
	}
	@Override
	public int deletePatientbyId(int pId) throws PatientException {
		idao=new DaoImpl();
		 return idao.deleteById(pId);
		
	}
}

	
