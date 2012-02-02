package SQL;

import java.sql.*;
import java.io.*;
public class SQLOprOrdre {

	public static void main(String[] args) {
		try {
			System.out.println("Vi vil nu oprette en ny Ordre");
			BufferedReader inLine = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Indtast KundeId (Kunden skal være oprettet på forhånd");
			String kundeId=inLine.readLine();
			System.out.println("Indtast VareNr (Vare skal være oprettet på forhånd");
			String vareNummer=inLine.readLine();
			int vareNr = Integer.parseInt(vareNummer);
			System.out.println("Indtast Ordredato");
			String ordreDato=inLine.readLine();
			System.out.println("Indtast antal");
			String antalOrdre=inLine.readLine();
			int antal = Integer.parseInt(antalOrdre);
			Connection minConnection;
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			minConnection = DriverManager.getConnection("jdbc:odbc:OrdreSystem","","");
			Statement stmt = minConnection.createStatement();
			stmt.execute("insert into Ordre values ('" + kundeId + "', " + vareNr + ", '" + ordreDato + "', " + antal +")" );
			System.out.println("Ordren er nu registreret");
     		if (stmt != null) stmt.close();
			if (minConnection != null) minConnection.close();
		}
		catch (SQLException e) {
			        switch (e.getErrorCode())
			        { case 547 : {if (e.getMessage().indexOf("Kunde")!= -1)
										System.out.println("Kunde er ikke oprettet");
								  if (e.getMessage().indexOf("Vare")!= -1)
										System.out.println("Vare er ikke oprettet");
								  break;
			        			}
			          case 2627: {System.out.println("den pågældende ordre er allerede oprettet");
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
