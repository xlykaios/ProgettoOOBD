import java.util.*;

public class Meeting {
	Date Appuntamento;
	boolean Modalità; //online/offline
	int Num_partecip;
	String Argomenti;
	ArrayList<User> partecipanti;
	
	public Meeting() {
		
	}
	public Meeting ModifyMeet(Meeting a) {
		return a;
	}
	public Meeting ModifyUsers(Meeting a) {
		return a;
	}
}
