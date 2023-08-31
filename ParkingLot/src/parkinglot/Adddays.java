package parkinglot;

import java.security.PublicKey;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


	


public class Adddays {
	String curr_date;
	String date;
	public String datecheckformonth(String date)
	{
		this.date=date;
		 
		Date date1;
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date1);
			    
			cal.add(Calendar.DATE, 31); 
			Date dateWith5Days = cal.getTime();
			 SimpleDateFormat DateFormat= new SimpleDateFormat("yyyy-MM-dd"); 
			 Calendar c = Calendar.getInstance();
			 curr_date= DateFormat.format(dateWith5Days);
//		    System.out.println("Formatted Date: " +curr_date);
			//System.out.println(dateWith5Days);
			 
			
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		return curr_date;
	
	}
	
	public String datecheckforday(String date)
	{
		this.date=date;
		 
		Date date1;
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date1);
			    
			cal.add(Calendar.DATE, 1); 
			Date dateWith5Days = cal.getTime();
			 SimpleDateFormat DateFormat= new SimpleDateFormat("yyyy-MM-dd"); 
			 Calendar c = Calendar.getInstance();
			 curr_date= DateFormat.format(dateWith5Days);
//		    System.out.println("Formatted Date: " +curr_date);
			//System.out.println(dateWith5Days);
			 
			
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		return curr_date;
	
	}
	public String datecheckforshift(String date)
	{
		this.date=date;
		 
		Date date1;
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date1);
			    
			cal.add(Calendar.DATE, 1); 
			Date dateWith5Days = cal.getTime();
			 SimpleDateFormat DateFormat= new SimpleDateFormat("yyyy-MM-dd"); 
			 Calendar c = Calendar.getInstance();
			 curr_date= DateFormat.format(dateWith5Days);
//		    System.out.println("Formatted Date: " +curr_date);
			//System.out.println(dateWith5Days);
			 
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return curr_date;
	
	
	}
	
}
