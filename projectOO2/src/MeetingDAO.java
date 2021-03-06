import java.sql.*;


public class MeetingDAO {
	public static void addMeeting() throws SQLException {
		 try {

			 Class.forName("org.postgresql.Driver");

			 } catch (ClassNotFoundException e) {

			 System.out.println("Where is your PostgreSQL JDBC Driver? ” + “Include in your library path!");
			 e.printStackTrace();
			 return;

			 }

			 System.out.println("PostgreSQL JDBC Driver Registered!");

			 Connection connection = null;

			 try {

			 connection = DriverManager.getConnection("jdbc:postgresql://vexera.ddns.net:44044/project", "User",
			 "1234");

			 } catch (SQLException e) {

			 System.out.println("Connection Failed! Check output console");
			 e.printStackTrace();
			 return;

			 }

			 if (connection != null) {

			 System.out.println("Successfully added");
			 int ID = 0; //inserire valore id 
			 String Name = ""; //inserire nome meeting
			 String Date = ""; //inserire orario meeting
			 String Argomenti = ""; //inserire argomenti meeting
			 int[] lista_users = {0,1,2}; //inserire lista utenti partecipanti tramite i loro id
			 //regolare i constraints in base all'esistenza del partecipante(if cases)
			 Boolean online = false; //inserimento del tipo di meeting
			 
			 
			 String sql = "insert into public.meeting";
			 
			 Statement stmt = connection.createStatement();
			 stmt.executeUpdate( sql + " VALUES('"+ID+"','"+Name+"','"+Date+"','"+Argomenti+"','"+lista_users+"','"+online+"');");
				 }
		 }
	}

