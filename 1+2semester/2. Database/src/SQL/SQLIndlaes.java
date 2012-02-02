package SQL;

import java.sql.*;
import java.io.*;
	public class SQLIndlaes {
	public static void main(String[] args) {
		try {
			System.out.println("Indtast delstreng");
			BufferedReader inLine = new BufferedReader(new InputStreamReader(System.in));
			String in=inLine.readLine();
			Connection minConnection;
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			minConnection = DriverManager.getConnection("jdbc:odbc:OrdreSystem","","");
			Statement stmt = minConnection.createStatement();
			System.out.println("select KundeId, Navn from Kunde where Navn like '%" + in + "%'");
			ResultSet res=stmt.executeQuery("select KundeId, Navn from Kunde where Navn like '%" + in + "%'");
			while (res.next()) {
				System.out.println(res.getString(1) + "    " + res.getString(2));
			}
			if (res != null) res.close();
			if (stmt != null) stmt.close();
			if (minConnection != null) minConnection.close();
		}
		catch (Exception e) {
			System.out.println("fejl:  "+e.getMessage());
		}
	}
}
