import java.util.*;

public class User {
	String CF_User;
	String nome;
	String cognome;
	String Birthday; //data di nascita in formato GG-MM-AAAA
	String Address;
	int /*provvisorio*/ valutazione;
	
	
	public User() {
		Scanner Userin = new Scanner(System.in);
		System.out.println("Inserisci CF utente"); //sarà poi autogenerato dal DB nel caso di ID keys
		CF_User = Userin.next();
		//check sul CF affinché rispetti il formato nazionale
		System.out.println("Inserisci Nome utente");
		nome = Userin.next();
		System.out.println("Inserisci Cognome utente");
		cognome = Userin.next();
		System.out.println("Inserisci Data di nascita");
		Birthday = Userin.next();
		//check su bday per controllare formato GG-MM-AAAA
		System.out.println("Inserisci Indirizzo");
		Address = Userin.next();
		valutazione = 0;
	}
	
	public void getSkills() {
		//skills generali dell'utente, gestite tramite enum o codice skill , es 01 = programmazione , 02 = marketing etc etc
	}
	public void getID() {
		//?? placeholder
	}
	public void ProjList() {
		//controllo nella lista di tutti i progetti effettuati, if user is in Project, then Print project title/ID + Role
	}
	public void getSalario() {
		//salario medio controllato tra i salari di tutti i progetti, quindi valori ricavabili da projlist
	}
	// add e delete gestiti da main
}
