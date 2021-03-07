
public class Utenti {
	int ID;
	String Nome;
	String Cognome ;
	Float Salario;
	String CF;
	int Valutazione;
	
	@Override
	public String toString(){
		return Nome+" "+Cognome;
	}
	
	public Utenti(int user_ID, String user_Name, String user_Surname, String cF2) {
		ID = user_ID;
		Nome = user_Name;
		Cognome = user_Surname;
		Float Salario;
		CF = cF2;
		int Valutazione;
	}
	
}
