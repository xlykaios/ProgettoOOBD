import java.sql.*;
import java.util.ArrayList;
/* Creazione di una classe dao unificata contenente tutte le funzioni di DAO da comunicare alle successive tramite inherit da extend di classe */
/* Le Classi dao che devono essere prese in considerazione sono quelle di MEETING e PROGETTO in quanto per l'utente viene
 * utilizzata una semplice associazione di classe di tipo oggetto*/

/* Le funzioni da implementare saranno : 
 * 1) Impostazione di connessione al database, specificando tipo di connessione e variabile di accesso, il richiamo di una funzione del dao darà
 * accesso diretto al database 
 * 2) Eventuali funzioni singole di DAO da implementare con l'sql per ottenere i risultati voluti*/
public class FinalDAO {
	
	public enum Ambito {
		Informatica,
		Fisica,
		Matematica,
		Economia,
		Medicina,
		Automatismi,
		Meccanica
	}
	
	public enum Tipo{
		Ricerca di Base,
		Ricerca Industriale,
		Ricerca Sperimentale,
		Sviluppo Industriale,
		Sviluppo Sperimentale
	}
	
	static ArrayList<Utenti> partecip;
		/* Si parte dal presupposto che una funzione di tipo connessione debba essere necessariamente utilizzata
		 * dal momento che tutte le funzioni di SQL richiedono un parametro di tipo Connection dalla jSQL*/
	
	
	public static Connection connessione() throws SQLException{
		 try {
			 	 Class.forName("org.postgresql.Driver");
				 } catch (ClassNotFoundException e) {
				 System.out.println("Where is your PostgreSQL JDBC Driver? ” + “Include in your library path!");
				 e.printStackTrace();
				 return null;
				 }
				 System.out.println("PostgreSQL JDBC Driver Registered!");
				 Connection connection = null;
				 try {
				 connection = DriverManager.getConnection("jdbc:postgresql://vexera.ddns.net:44044/project", "User",
				 "1234");
				 } catch (SQLException e) {
				 System.out.println("Connection Failed! Check output console");
				 e.printStackTrace();
				 return null;
				 }
				 return connection;
			 }
	public static void addMeeting() throws SQLException {
		 Connection connection = FinalDAO.connessione();
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
	public static void getProjectsbyTopic() throws SQLException{
		Connection connection = FinalDAO.connessione();
		 //inserire qui la stringa di selezione dinamica del tipo di dato ricercato
		 String search = "ambito = '' ";
		 String sql = "select * from public.progetti where";
		
		 Statement stmt = connection.createStatement();
		 ResultSet rs = stmt.executeQuery( sql + search );
		 //qui verranno riportati tutti i valori ottenuti dal getprojects by topic
		 while ( rs.next() ) {

			   int ID = rs.getInt("ID");

			   String Nome = rs.getString("name");
			   
			   Ambito Topic = rs.getStatement("ambito");
			   
			   Tipo Type = rs.getStatement("tipo");
			   
			   String Ambito1 = Topic.toString();
			   
			   String Tipo1 = Type.toString();
			   
			   System.out.printf( "ID = %s , Nome = %s, Ambito = %s , Tipo = %s ", ID ,Nome, Ambito1 , Tipo1 );

			   System.out.println();

		 		}	
			 }
	public static void AddProject() throws SQLException{
		 Connection connection = FinalDAO.connessione();
			 
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
	
	public static void GetPartecipanti() throws SQLException{
		 Connection connection = FinalDAO.connessione();

		 System.out.println("Successfully added");
		 ArrayList<Utenti> partecipanti = new ArrayList<Utenti>();
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
			 
		 String intValue = utenti.replaceAll("[^0-9]", " ");
			
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
	 		String Role = r1.getString("Ruolo");
	 		partecipanti.add(new Utenti(User_ID,User_Name,User_Surname,CF,Role));
			 		}
			 	}
			 }	partecip = partecipanti;
			 }

} 