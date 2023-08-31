package parkinglot;

import java.util.Date;
import javax.swing.JOptionPane;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.time.*;
import java.sql.*;

public class monthly extends TypeofBooking{
	String monthlyendDate;
	int remainingdays;

	String Monthlystartdate;
	static int newslotnumformonthly=0;
	Adddays adddays=new Adddays();
	sqlqueries sq=new sqlqueries();
	Connection conn=DBconnection.connect();
	ExistingCustomerLogin namefrom=new ExistingCustomerLogin();
	public monthly()
	{
		
	}
	
	public int monthlyslot(String Monthstartdate)
	{
		this.Monthlystartdate=Monthstartdate;
		
		try {
			
			String query="select max(monthlyslot_1to10) from twowheeler where monthlyslot_1to10 in (select monthlyslot_1to10 from twowheeler where monthstartdate=?);";
			
			PreparedStatement pS=conn.prepareStatement(query);
			pS.setString(1, Monthlystartdate);
			ResultSet rSet=pS.executeQuery();
			rSet.next();
			if(rSet.getString(1)==null)
			{
				//System.out.println("null");
				newslotnumformonthly=1;
			}
			else {
				//System.out.println("1");
				newslotnumformonthly=rSet.getInt(1)+1;
			}
			
			conn.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return newslotnumformonthly;
	}
	
	public void insertmonthly(String Vehicle_no,String Name, String Monthlystartdate)
	{
		this.Monthlystartdate=Monthlystartdate;
		this.vehicle_no=Vehicle_no;

		try {
		
			monthlyendDate=adddays.datecheckformonth(Monthlystartdate);
			String query1=sq.insertmonthlyTW;
			PreparedStatement ps1=conn.prepareStatement(query1);
			ps1.setString(1, vehicle_no);
			ps1.setString(2, Name);
			ps1.setString(3,  Monthlystartdate);
			ps1.setString(4, monthlyendDate);
			ps1.setInt(5, monthlyslot(Monthlystartdate));
			ps1.executeUpdate();
			conn.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		

		
		
		
	}











//public static void main(String[] args) throws SQLException{
//	   //SimpleDateFormat df = new SimpleDateFormat("yyyy/mm/dd");
//	
////		monthly M_monthly=new monthly("TN01AP3827","2023-12-12");//changed monthly here.
//	
//	
//		
//	
//}
	
}
	
	