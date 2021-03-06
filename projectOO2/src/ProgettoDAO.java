import java.sql.*;

public class ProgettoDAO{
	private final String url = "jdbc:postgresql://vexera.ddns.net:44044/project";
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
	    }
	 public static void getProjectsbyTopic() throws SQLException{
		 //inserire qui la stringa di selezione dinamica del tipo di dato ricercato
		 String search = "ambito = '' ";
		 String sql = "select * from public.progetti where";
		 ProgettoDAO byTopic = new ProgettoDAO();
		 Connection conn=byTopic.connect();
		 Statement stmt = conn.createStatement();
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
	 public static void AddProject() throws SQLException{
		 int ID = 0; //inserire valore id 
		 boolean state = true;
		 int[] lista_users = {0,1,2}; //inserire lista utenti partecipanti tramite i loro id
		 String tipo = "test"; //inserimento del tipo
		 String ambito = "test"; //inserimento dell'ambito
		 String name = "test"; //inserimento del nome progetto
		 
		 String sql = "insert into public.progetti";
		 ProgettoDAO byTopic = new ProgettoDAO();
		 Connection conn=byTopic.connect();
		 Statement stmt = conn.createStatement();
		 stmt.executeUpdate( sql + "VALUES('"+ID+"','"+state+"','"+lista_users+"','"+tipo+"','"+ambito+"','"+name+"');");
		 
	 }
}

