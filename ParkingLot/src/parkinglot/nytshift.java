package parkinglot;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class nytshift extends shift {
	int newnytshiftslot=0;
	
	public void nytshift(String Vehicle_no,String Shiftdate)
	{
		this.vehicle_no=Vehicle_no;
		this.shiftdate=Shiftdate;
		
		
		sqlqueries q1=new sqlqueries();
		Connection conn=DBconnection.connect();
		String query="select max(Nytshiftslot_31to50) from twowheeler where Nytshiftslot_31to50 in (select Nytshiftslot_31to50 from twowheeler where shiftdate=?;";
		String query1=q1.insertshiftTW;
		try {
			PreparedStatement pS=conn.prepareStatement(query);
			pS.setString(1, shiftdate);
			ResultSet rSet=pS.executeQuery();
			rSet.next();
			if(rSet.getString(1).equals(null))		{
				newnytshiftslot=31;
			}
			else if (rSet.getInt(1)>50) {
				JOptionPane.showMessageDialog(null, "Sorry Morning Slots for Today are completely booked ( ^!^ )");
			}
			else {
				newnytshiftslot=rSet.getInt(1)+1;
			}
			
			PreparedStatement pS1=conn.prepareStatement(query1);
			pS1.setString(1, vehicle_no);
			pS1.setString(2, shiftdate);
			pS1.setString(3, "Nyt");
			pS1.setInt(4, newnytshiftslot);
			pS1.executeUpdate();		
			conn.close();			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
