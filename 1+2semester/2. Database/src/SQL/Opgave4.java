package SQL;

import java.sql.*;

public class Opgave4 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
			Connection con;
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:lappy","","");
			Statement stmt = con.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery("SELECT k.ktoNr, navn, ku.cprNr FROM Konto k INNER JOIN KundeHarKonto khk on khk.ktoNr = k.ktoNr INNER JOIN Kunde ku on ku.cprNr = khk.cprNr WHERE ku.cprNr = 3112692132");
			
		while(rs.next()){
			System.out.println(rs.getString(1) + "       " + rs.getString(2) + "       " + rs.getString(3));
		}
		
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		if(con != null) con.close();
		}
		catch(Exception e){
			System.out.println("Fejl: " + e.getMessage());
		}
		
		}
}
