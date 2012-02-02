package SQL;

import java.sql.*;
import java.io.*;
public class SQLOprOrdrePre {

	public static void main(String[] args) {
		try {
			System.out.println("Vi vil nu oprette en ny ordre");
			BufferedReader inLine = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Indtast Kundenummer (Kunden skal være oprettet på forhånd)");
			String kundenr=inLine.readLine();
			System.out.println("Indtast Varenummer (Varen skal være oprettet på forhånd)");
			String varenr=inLine.readLine();
			System.out.println("Indtast Ordredato (ex. 2008-08-31)");
			String ordredato=inLine.readLine();
			System.out.println("Indtast antal");
			String antalstr=inLine.readLine();
			int antal = Integer.parseInt(antalstr);
			Connection minConnection;
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			minConnection = DriverManager.getConnection("jdbc:odbc:OrdreSystem","","");
			String sql = "insert into harOrdre values (?,?,?,?)";
			PreparedStatement prestmt = minConnection.prepareStatement(sql);
			prestmt.clearParameters();
			prestmt.setString(1,kundenr);
			prestmt.setString(2,varenr);
			prestmt.setString(3,ordredato);
			prestmt.setInt(4,antal);
			prestmt.execute();
			System.out.println("Ordren er nu oprettet");
			if (prestmt != null) prestmt.close();
			if (minConnection != null) minConnection.close();
		}
		catch (SQLException e) {
			        switch (e.getErrorCode())
			        { case 547 : {if (e.getMessage().indexOf("Kunde")!= -1)
										System.out.println("Kunden er ikke oprettet");
								  if (e.getMessage().indexOf("Vare")!= -1)
										System.out.println("Varen er ikke oprettet");
								  break;
			        			}
			          case 2627: {System.out.println("Ordren eksisterer allerede");
			          	          break;
			         			 }
			          default: System.out.println("fejlSQL:  "+e.getMessage());
				};
		}
		catch (Exception e) {
			System.out.println("fejl:  "+e.getMessage());
		}
	}
} 
