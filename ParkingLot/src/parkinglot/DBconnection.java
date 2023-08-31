package parkinglot;
import java.sql.*;

public class DBconnection {
	static Connection connection = null;
    public static Connection connect(){
        try {

           // String url = "jdbc:mysql://localhost:3306/";
            String url="jdbc:mysql://@localhost:3306/";
            String dataBase = "ParkingLot";
            String user = "root";
            String password = "root";
            connection = DriverManager.getConnection(url+dataBase, user, password);
        }
        catch (Exception e) 
        {
        	e.printStackTrace();

        }
        return connection;
    }
}