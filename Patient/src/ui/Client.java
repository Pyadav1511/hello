package ui;

import java.util.ArrayList;
import java.util.Scanner;

import exception.PatientException;
import service.Iservice;
import service.ServiceImpl;
import bean.Patientbean;


public class Client {
	static Iservice serv=null;
	static Patientbean p=null;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int Option;
		System.out.println("Menu");
		System.out.println("1.Add");
		
		System.out.println("2.Delete  By Id");
		System.out.println("3.Update By name");
		System.out.println("4.Retrieve By id");
		System.out.println("5.Retrieve all");
		System.out.println("Exit");
		Option=sc.nextInt();
		
		switch (Option){
		case 1:
			p=new Patientbean();
			System.out.println("Enter name");
			String name=sc.next();
			boolean t=validateName(name);
			if(t==true)
			{
			p.setName(name);
		// validate it
			// if
			
			try {
				int id = addPatient(p);
				System.out.println("data is added!!! ur emp id is : " + id);
			} catch (PatientException e) {
				System.out.println(""+e.getMessage());
			}
			}else{System.out.println("The name should contain only alphabets and first letter must be uppercase");}
			
			break;
			
	case 2:
					 p = new Patientbean();
					System.out.println("eneter the id u wanna delete");
					int sId = sc.nextInt();
			try {
				deleteEmployee(sId);
			} catch (PatientException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			break;
	case 3 :      
		try {
			p = new Patientbean();
					System.out.println("eneter the id where you want to update");
					int Id = sc.nextInt();
					System.out.println("enter your name to be updated");
					String name1=sc.next();
					//emp11.setEmpId(Id);
					//emp11.setName(name);
			
				updatePatient(Id,name1);
			} catch (PatientException e) {
				System.out.println(""+e.getMessage());
			}
					break;
					
					
	case 4:		p = new Patientbean();
				System.out.println("enter the id u wanna search...");
				int searchId = sc.nextInt();
			try {
				p=retrieveByid(searchId);
			
				System.out.println(p);
			} catch (PatientException e1) {
				System.out.println("ERror" +e1.getMessage());
			}
				break;
						
	case 5:			ArrayList<Patientbean> pList=retrieveAll();
				//empList.stream().forEach(System.out::println);
			for(Patientbean p:pList)
			{
					System.out.println(p);
			}
						break;
						
	case 6:			System.exit(0);
					
	default:

		System.out.println("please enter a valid option between 1-6");
					}

}



	private static int deleteEmployee(int pId) throws PatientException {
		serv=new ServiceImpl();
		int ret=serv.deletePatientbyId(pId);
		return ret;
		
	}



	private static Patientbean retrieveByid(int searchId) throws PatientException {
		serv=new ServiceImpl();
		 return serv.retrieveById(searchId);
		
	}



	private static ArrayList<Patientbean> retrieveAll() {
	
		return null;
	}



	private static String updatePatient(int Patientid, String PatientName) throws PatientException {
		serv=new ServiceImpl();
		return serv.updatePatient(Patientid, PatientName);
		
	}


	private static boolean validateName(String name) {
		 serv=new ServiceImpl();
		return serv.validateName(name);
	}

	private static int addPatient(Patientbean p) throws PatientException {
		serv=new ServiceImpl();
		return serv.addPatient(p);
	}

}
