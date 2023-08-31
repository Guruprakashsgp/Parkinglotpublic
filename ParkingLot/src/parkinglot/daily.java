package parkinglot;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class daily extends TypeofBooking {


	int newdailyslot=0;
	String dailydate;
	int newwholedailyslot;
	sqlqueries q1=new sqlqueries();
	Connection conn=DBconnection.connect();
	
	
	public int daily(String dailydate)
	{
		this.dailydate=dailydate;
		
		
		String query="select max(dailyslot_11to30) from twowheeler where dailyslot_11to30 in (select dailyslot_11to30 from twowheeler where dailydate=?);";
		
		try {
			PreparedStatement pS=conn.prepareStatement(query);
			pS.setString(1, dailydate);
			ResultSet rSet=pS.executeQuery();
			rSet.next();
			if(rSet.getString(1)==null)
			{
				newdailyslot=11;
			}
			else if (rSet.getInt(1)>30) {
				JOptionPane.showMessageDialog(null, "Sorry the monthly slots are completely booked ( ^!^ )");
			}
			else {
				newdailyslot=rSet.getInt(1)+1;
			}
			
					
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		newwholedailyslot=newdailyslot;
		return newwholedailyslot;
	}
	public void dailyinsert(String Vehicle_no,String Name,String dailydate,int dailyslot)
	{
		try {
			String query1=q1.insertdailyTW;
			PreparedStatement pS1=conn.prepareStatement(query1);
			pS1.setString(1, vehicle_no);
			pS1.setString(2, Name);
			pS1.setString(3, dailydate);
			pS1.setInt(4,daily(dailydate));
			pS1.executeUpdate();		
			conn.close();	
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
}


