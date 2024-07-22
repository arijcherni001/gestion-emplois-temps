package emploiDuTemps_java;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnexionBD {
	Connection cn;
	public ConnexionBD(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost/emploidutemps_db","root","");
			System.out.println("Connection etablie!");
		}
		catch(Exception e){
			System.out.println("non connectee!");
		}
		
	}
    public Connection FConnection(){
    	return cn;
    }
}
