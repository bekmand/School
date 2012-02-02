package SQL;
import java.sql.*;
public class SQLAlle {

	public static void main(String[] args) {
		try {
			Connection minConnection;
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			minConnection = DriverManager.getConnection("jdbc:odbc:lappy","","");
			Statement stmt = minConnection.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet res=stmt.executeQuery("SELECT regNr, navn, adresse, tlfNr FROM Afdeling");
			while (res.next()) {
				System.out.println(res.getString("regNr") + "    " + res.getString("navn") + 
						"    " + res.getString("adresse") + "    " + res.getString("tlfNr"));
			}
			res.previous();
			res.previous();
			System.out.println("-----------PREVIOUS() x 2-------------");
			System.out.println(res.getString("regNr") + "    " + res.getString("navn") + 
					"    " + res.getString("adresse") + "    " + res.getString("tlfNr"));
			res.absolute(1);
			System.out.println("-----------ABSOLUTE(1)-------------");
			System.out.println(res.getString("regNr") + "    " + res.getString("navn") + 
					"    " + res.getString("adresse") + "    " + res.getString("tlfNr"));
			res.relative(1);
			System.out.println("-----------RELATIVE(1)-------------");
			System.out.println(res.getString("regNr") + "    " + res.getString("navn") + 
					"    " + res.getString("adresse") + "    " + res.getString("tlfNr"));
			res.first();
			System.out.println("-----------FIRST()-------------");
			System.out.println(res.getString("regNr") + "    " + res.getString("navn") + 
					"    " + res.getString("adresse") + "    " + res.getString("tlfNr"));
			res.last();
			System.out.println("-----------LAST()-------------");
			System.out.println(res.getString("regNr") + "    " + res.getString("navn") + 
					"    " + res.getString("adresse") + "    " + res.getString("tlfNr"));
			
			
			
			if (res != null) res.close();
			if (stmt != null) stmt.close();
			if (minConnection != null) minConnection.close();
		}
		catch (Exception e) {
			System.out.println("fejl:  "+e.getMessage());
		}
	}
}
