
public class Utenti {
	int ID;
	String Nome;
	String Cognome ;
	Float Salario;
	String CF;
	String Ruolo;
	int Valutazione;
	
	@Override
	public String toString(){
		return Nome+" "+Cognome+" // "+Ruolo;
	}
	
	public Utenti(int user_ID, String user_Name, String user_Surname, String cF2, String Role) {
		ID = user_ID;
		Nome = user_Name;
		Cognome = user_Surname;
		Float Salario;
		CF = cF2;
		Ruolo = Role;
		int Valutazione;
		
	}
	
}
