package dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;







import javax.sql.ConnectionEvent;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import util.DbUtil;
import util.IQuerryMapper;
import exception.PatientException;
import bean.Patientbean;

public  class DaoImpl implements Idao{
static Logger log=null;
	
Connection con=null;
Idao idao=null;

	public DaoImpl() {
		// TODO Auto-generated constructor stub
		PropertyConfigurator.configure("src/resource/log4j.properties");
		log=Logger.getRootLogger();
		
				
	}
	@Override
	public int addPatient(Patientbean p) throws PatientException {
		log.info("Hello ");
		int retId = 0;
		try {
			con = DbUtil.getConnection();
			PreparedStatement pst = con.prepareStatement(IQuerryMapper.INSERT_Patient);
			pst.setString(1,p.getName());
			int status = pst.executeUpdate();

			System.out.println("Inserted records successfully!");
			if (status >= 1) {
						pst = con.prepareStatement(IQuerryMapper.EMP_SEQ_CURR_ID);
				ResultSet rs = pst.executeQuery();

				if (rs.next()) {
					retId = rs.getInt(1);
					
				}
			}

		} catch (SQLException e) {
			// throw it user defined excep
			throw new PatientException("DB problem : " + e.getMessage());

		}
		return retId;
	}
	@Override
	public Patientbean getpatientDetails(int PatientId) throws PatientException{
		Patientbean pp=null;
			try {
						con=DbUtil.getConnection();
						PreparedStatement ps=con.prepareStatement(IQuerryMapper.RETRIEVE_BY_ID);
						ps.setInt(1,PatientId );
						ResultSet rs=ps.executeQuery();
						
						if(rs.next())
						{
							pp=new Patientbean();
							//System.out.println("ID :"+rs.getInt(1));
							//System.out.println("Name :"+rs.getString(2));
							//System.out.println("Date  :"+rs.getDate(3));
							pp.setId(rs.getInt(1));
							pp.setName(rs.getString(2));
							pp.setDate(rs.getDate(3));
							/* pp.setName(rs.getString(2));
							 Date d=new Date();
							 d=rs.getDate(3);
							 pp.setDate(d);*/
							 System.out.println("Hi");
						}

			}
			catch (SQLException e) {
				throw new PatientException("Error"+e.getMessage());
			}

		
		return pp;
}
	/*@Override
		public ArrayList<Patientbean> retrieveAll() throws PatientException {
			ArrayList<Patientbean> empList = new ArrayList<Patientbean>();
			try {
				con = DbUtil.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(IQuerryMapper.Retrieveall);
				Patientbean p = null;

				while (rs.next()) {
					p = new Patientbean();
					
					p.setName(rs.getString(1));
					empList.add(p);
				}

			} catch (SQLException e) {
				throw new PatientException("exception occured :: "
						+ e.getMessage());
			}

			return empList;
		}*/
	@Override
	public String updatePatient(int Patientid, String PatientName) throws PatientException{
			try {
				con=DbUtil.getConnection();
			log.info("database is connected");
			PreparedStatement pst=con.prepareStatement("update Patient11 set PatientName=? where Patientid=?");
			pst.setInt(1, Patientid);
			pst.setString(2, PatientName);
			log.info("query is ready to execute");
			int status=pst.executeUpdate();
			log.warn("data is updated successfull"+status);
			} catch (SQLException e) {
				throw new PatientException("Error"+e.getMessage());
			}
		return null;
	}
	@Override
	public Patientbean retrieveById(int searchId) throws PatientException {
		Patientbean re=new Patientbean();
				try {
					con=DbUtil.getConnection();
				
				log.info("program for retrive by id ");
				PreparedStatement st=con.prepareStatement(IQuerryMapper.RETRIEVE_BY_ID);
				st.setInt(1, searchId);
				log.info("id is  "+searchId);
				ResultSet rs=st.executeQuery();
				log.warn("data may not be fetch from database ");
			
				if(rs.next()){
					/*System.out.println(rs.getInt(1));
					System.out.println(rs.getString(2));
					System.out.println(rs.getString(3));
					System.out.println(rs.getInt(4));
					System.out.println(rs.getString(5));*/
					re.setId(rs.getInt(1));
					re.setName(rs.getString(2));
				
					//re.settdate(rs.getString(5));
					//System.out.println(re);
					log.info("data is retrive successfull  by id");
					
					}
				}catch (SQLException e) {
					throw new PatientException("exception occured :: "
							+ e.getMessage());
				}
				return re;
				
	}
	@Override
	public int deleteById(int pId) {
		try {
			con = DbUtil.getConnection();
			log.info("data base is connected ");
			PreparedStatement pst = con.prepareStatement(IQuerryMapper.DELETE_BY_ID);
			pst.setInt(1, pId);
			log.info("query is redy to execute..");
			int status = pst.executeUpdate();
			log.warn("there is problem with your query or database to retrive by id");
			log.info("data is deleted from table");
			System.out.println("Delete "+status);
			log.info("data is deleted successfull "+status);
		}
		catch (SQLException e1) {
			log.error("error : "+e1.getMessage());
		System.out.println(e1.getMessage());
		}
		return 0;
	}
}
	