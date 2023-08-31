package parkinglot;

public class sqlqueries {
	//to select all//
	public String selectmonthlyTW = "select * from twowheeler where(monthstartdate is not null and Monthlyslot_1to10 < 10);";
	public String selectdailyTW="select * from twowheeler where (dailydate is not null and Dailyslot_11to30 between 11 and 30);";
	public String selectmorningshiftTW="select * from twowheeler where (shiftdate is not null and morningshift is not null and Shiftslot_31to50 between 31 and 50);";
	public String selectafternoonshiftTW="select * from twowheeler where (shiftdate is not null and afternoonshift is not null and Shiftslot_31to50 between 31 and 50);";
	public String selectnytshiftTWString="select * from twowheeler where (shiftdate is not null and Nytshift is not null and Shiftslot_31to50 between 31 and 50);";
	
	//to insert//
	public String insertmonthlyTW="Insert into twowheeler(Vehicle_no,Name,Monthstartdate,Monthenddate,Monthlyslot_1to10) values(?,?,?,?,?);";
	public String insertdailyTW="Insert into twowheeler(vehicle_no,Name,Dailydate,Dailyslot_11to30) values(?,?,?,?);";
	public String insertshiftTW="Insert into twowheeler(vehicle_no,Name,Shiftdate,shifttype,Morningshiftslot_31to50) values(?,?,?,?,?);";

	
	//to select particular slots//
	public String selectslotformorningTW="select Shiftslot_31to50 from twowheeler"
			+ "where((Shiftdate is null or shiftdate=?) "
			+ "and Morningshift is null and "
			+ "((Afternoonshift is not null or Nytshift is not null) or (Afternoonshift is null or Nytshift is not null) or (Afternoonshift is not null or Nytshift is null)or (Afternoonshift is null or Nytshift is null))"
			+ "and (Shiftslot_31to50 between 30 and 50))"
			+ "limit 1;";
	public String selectslotforafternoonTW="select Shiftslot_31to50 from twowheeler"
			+ "where((Shiftdate is null or shiftdate=?) "
			+ "and Afternoonshift is null and "
			+ "((Morningshift is not null or Nytshift is not null) or (Morningshift is null or Nytshift is not null) or (Morningshift is not null or Nytshift is null)or(Morningshift is null or Nytshift is null))"
			+ "and (Shiftslot_31to50 between 30 and 51))"
			+ "limit 1;";
	public String selectslotfornytTW="select Shiftslot_31to50 from twowheeler"
			+ "where((Shiftdate is null or shiftdate=?) "
			+ "and Nytshift is null and "
			+ "((Morningshift is not null or Afternoonshift is not null) or (Morningshift is null or Afternoonshift is not null) or (Morningshift is not null or Afternoonshift is null)or(Morningshift is null or Afternoonshift is null))"
			+ "and (Shiftslot_31to50 between 30 and 51))"
			+ "limit 1;";
	public String selectslotfordailyTW="select Dailyslot_11to30 from twowheeler"
			+ "where ((Dailydate is ?) and (Dailyslot_11to30 is null or (Dailyslot_11to30 between 11 and 30)))  limit 1;";//Returns 0 or date available
	public String toextenddailyslotTW="select Dailyslot_11to30 from twowheeler "
			+ "where ((Dailydate=?) and (Dailyslot_11to30 is null or (Dailyslot_11to30 between 11 and 30))) limit 1;";//Returns 0 or the date available
	public String selectslotformonthlyTW="select Monthlyslot_1to10 from twowheeler "
			+ "where ((Monthstartdate is null) and (Monthlyslot_1to10 is null or (Monthlyslot_1to10 between 1 and 10))) limit 1;";
	
	//to delete vehicle//
	
	public String deleteTW="Delete from twowheeler where Vehicle_no=?";
	
	//to get max//
	
	public String maxslotmonthlyTW="select max(Monthlyslot_1to10) from twowheeler;";
	public String maxslotdailyTW="select max(dailyslot_11to30) from twowheeler;";
	public String maxslotshiftTW="select max(shiftslot_31to50) from twowheeler;";
	
	
	public String slotfind="select max(shiftslot_31to50) from twowheeler where Shiftslot_31to50 in (select Shiftslot_31to50 from twowheeler where shiftdate=?);";

}
