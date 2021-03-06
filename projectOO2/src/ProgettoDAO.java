import java.sql.*;

public class ProgettoDAO{
	/* private final String url = "jdbc:postgresql://vexera.ddns.net:44044/project";
	private final String user = "User";
	private final String password = "1234";
	 public Connection connect() {
	        Connection conn = null;
	        try {
	            conn = DriverManager.getConnection(url, user, password);
	            System.out.println("Connected to the PostgreSQL server successfully.");
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }

	        return conn; 
	    } */
	 public static void getProjectsbyTopic() throws SQLException{
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

		 //inserire qui la stringa di selezione dinamica del tipo di dato ricercato
		 String search = "ambito = '' ";
		 String sql = "select * from public.progetti where";
		
		 Statement stmt = connection.createStatement();
		 ResultSet rs = stmt.executeQuery( sql + search );
		 //qui verranno riportati tutti i valori ottenuti dal getprojects by topic
		 while ( rs.next() ) {

			   int ID = rs.getInt("ID");

			   String Nome = rs.getString("name");

			   String Ambito  = rs.getString("ambito");
			   
			   String Tipo = rs.getString("tipo");

			   System.out.printf( "ID = %s , Nome = %s, Ambito = %s , Tipo = %s ", ID ,Nome, Ambito, Tipo );

			   System.out.println();

		 		}	
			 }
	 	}
	 public static void AddProject() throws SQLException{
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
		 boolean state = true;
		 int[] lista_users = {0,1,2}; //inserire lista utenti partecipanti tramite i loro id
		 String tipo = "test"; //inserimento del tipo
		 String ambito = "test"; //inserimento dell'ambito
		 String name = "test"; //inserimento del nome progetto
		 
		 String sql = "insert into public.progetti";
		 
		 Statement stmt = connection.createStatement();
		 stmt.executeUpdate( sql + "VALUES('"+ID+"','"+state+"','"+lista_users+"','"+tipo+"','"+ambito+"','"+name+"');");
			 }
	 }
	 
	 public static void GetPartecipanti() throws SQLException{
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
		 String select = "'ID'";  //selezione dell'id del progetto di cui stampare  la lista partecipanti
		 String sql = "select lista_IDusers from public.progetti where ID = ";
		 
		 Statement stmt = connection.createStatement();
		 int key = 1; //id del progetto ricercato
		 String utenti = "";
		 ResultSet rs = stmt.executeQuery( "select * from public.progetti");
		 while ( rs.next() ) {
		 	int ID = rs.getInt("ID_Proj");
		   
		    	if (ID==key) 
		    		utenti = rs.getString("lista_IDusers");
		 } // FINE QUERY RICERCA PROGETTO

		 //INZIO QUERY STAMPA UTENTI
		 System.out.println(utenti);
		 String intValue = utenti.replaceAll("[^0-9]", " ");
		 System.out.println(intValue);
		 for(int i = 0; i < intValue.length(); i++) {
		 	char ch = intValue.charAt(i);
		 	String temp="";
		 	if(Character.isDigit(ch)) {
		 		temp += ch;
		 		int numb = Integer.parseInt(temp);
		 		
		 		Statement stmt2 = connection.createStatement();
		 		ResultSet r1 = stmt2.executeQuery("SELECT * FROM utenti WHERE \"ID\" = '"+numb+"'");
		 		while ( r1.next() ) {
		 			
		 			//valori da passare alla table
		 		int User_ID = r1.getInt("ID");
		 		String User_Name = r1.getString("Nome");
		 		String User_Surname = r1.getString("Cognome");
		 		String CF = r1.getString("CF");
		 		
		 		}
		 	}
		 }
	 }
	}
}

