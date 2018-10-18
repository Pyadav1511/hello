package service;

import java.util.ArrayList;

import exception.PatientException;
import bean.Patientbean;

public interface Iservice {

int addPatient(Patientbean p) throws PatientException;
public boolean validateName(String name);
public Patientbean getpatientDetails(int PatientId) throws PatientException;
String updatePatient(int id, String name1)throws PatientException;
public Patientbean retrieveById(int searchId)throws PatientException;
public int deletePatientbyId(int pId) throws PatientException;

}
