package test;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import dao.DaoImpl;
import dao.Idao;
import exception.PatientException;
import bean.Patientbean;

public class Testclass {
	static Idao i=null;
	@BeforeClass
	public static void init()
	{
		i=new DaoImpl();
	}
	@Test
public void testinsert() throws PatientException
	{
		 Patientbean pb=new Patientbean();
		 pb.setName("ROHAN");
		 Assert.assertEquals("FAILED",17,i.addPatient(pb));
		
	}
	@Test
	public void testinsert1() throws PatientException
	{
		 Patientbean pb1=new Patientbean();
		 pb1.setName("Yash");
		Assert.assertEquals("FAILED",17,i.addPatient(pb1));
	
}

}
