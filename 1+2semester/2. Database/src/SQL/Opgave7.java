package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Opgave7 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
			Connection con;
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:lappy","","");
			Statement stmt = con.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		System.out.println("Indtast Char: ");
		String CHAR = br.readLine().toString();
		System.out.println("Indtast VarChar: ");
		String VARCHAR = br.readLine().toString();
		System.out.println("Indtast Int: ");
		int INT = Integer.parseInt(br.readLine().toString());
		System.out.println("Indtast Decimal: ");
		double DECIMAL = Double.parseDouble(br.readLine().toString());
		System.out.println("Indtast DateTime: ");
		String DATETIME = br.readLine().toString();
		System.out.println("Indtast Bit");
		boolean BIT = Boolean.parseBoolean(br.readLine().toString());
		
		String sql = "INSERT INTO TESTTYPE1 SELECT '" + CHAR + "', '" + VARCHAR + "', '" + INT + "', '" + DECIMAL + "', '" + DATETIME + "', '" + BIT + "'";
		stmt.execute(sql);
		
		ResultSet rs = stmt.executeQuery("SELECT * FROM TESTTYPE1");
		
		while(rs.next()){
			String rsChar = rs.getString(1);
			String rsVarChar = rs.getString(2);
			int rsInt = rs.getInt(3);
			double rsDouble = rs.getDouble(4);
			String rsDateTime = rs.getString(5);
			boolean rsBit = rs.getBoolean(6);
			
			System.out.println();
			System.out.println(rsChar + "  " + rsVarChar + "  " + rsInt + "  " + rsDouble + "  " + rsDateTime + "  " + rsBit);
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
