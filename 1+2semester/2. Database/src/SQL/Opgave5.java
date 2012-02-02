package SQL;
import java.sql.*;

public class Opgave5 {
	public static void main(String[] args) {
		try{
			Connection con;
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:lappy","","");
			Statement stmt = con.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			stmt.execute("INSERT INTO medarbejder VALUES (123412, 1234,'hr','peter petersen', 'heromkring 123', 1313 )");
			
			if(stmt != null) stmt.close();
			if(con != null) con.close();
			}
			catch(Exception e){
				System.out.println("Fejl: " + e.getMessage());
			}
	}
}
