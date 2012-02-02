package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Opgave6 {
	private static ArrayList<transaktion> ta = new ArrayList<transaktion>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
			Connection con;
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:lappy","","");
			Statement stmt = con.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery("SELECT * FROM Transaktion");
			
		while(rs.next()){
			transaktion t = new transaktion(rs.getInt("regNr"), rs.getInt("ktoNr"), rs.getString("dato"), rs.getString("tekst"), rs.getDouble("beløb"));
			ta.add(t);
		}
		
		System.out.println(ta.toString());
		
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		if(con != null) con.close();
		}
		catch(Exception e){
			System.out.println("Fejl: " + e.getMessage());
		}
		
		}
	

}
