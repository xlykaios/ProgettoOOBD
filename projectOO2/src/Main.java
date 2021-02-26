import java.util.*;
public class Main {
	
	public static void main(String[] args) {
		int Num_Proj=0;
		int ActiveID = 0;
		
		// generare arraylist di progetti e arraylist di utenti
		// i progetti prendono utenti singoli dall'arraylist generale da inserire all'interno dell'array list specifica di progetto
		ArrayList<Project> Progetti = new ArrayList<Project>();
		ArrayList<User> Utenti = new ArrayList<User>();
		// questi verranno poi conservati o estratti da un DBASE	

		// Menu del main
		menu_principale(Progetti,Utenti,ActiveID);
		// usare il sizing per ricercare all'interno dell'arraylist , studiare un meccanismo di estrapolazione del solo titolo per la scelta del progetto
		
	}
	public static void menu_principale(ArrayList<Project> Progetti , ArrayList<User> Utenti , int ActiveID){
		Scanner in =  new Scanner(System.in);
		int scelta=0;
		boolean menu_main = true;
		while(menu_main) {
			stampa("piccolo coglioncello, che cosa vuoi fare? ");
			stampa("1) accedi al menu gestione progetti ");
			stampa("2) accedi al menu gestione utenti ");
			stampa("0) esci dal programma ");
			scelta = in.nextInt();
			switch(scelta) {
				case 0:
					menu_main=false;
					break;
				case 1:
				 menu_progetti(ActiveID , Progetti);
					break;
				case 2:
				//placeholder funzione menu utenti
					break;
				default: 
					stampa("selezione errata, riprovare "); //throw exception wrong selection
			}
		}
	}
	public static void menu_progetti(int ActiveID , ArrayList<Project> Progetti) {
		Scanner in = new Scanner(System.in);
		int scelta;
		int Key;
		boolean status = true;
		while(status) {
		stampa("!/!/!/! Menu Progetti !/!/!/! ");
		stampa("1) Aggiungi progetti ");
		stampa("2) Mostra progetti esistenti");
		stampa("3) Modifica Progetti ");
		scelta = in.nextInt();
		switch(scelta) {
		case 0: status=false;
			break;
		case 1: 
			ActiveID = Project.addProjects(ActiveID , Progetti); 
			//status = false;
			break;
		case 2:
			Project.StampaInfoProgetti(Progetti);
			//status = false;
			break;
		case 3:
			Key=Project.SceltaProj(Progetti);
			Project.modificaProgetto(Progetti, Key);
			//status = false;
			break;
		default:
		}
		}
	}
	public void menu_utenti() {
		//placeholder menù utenti
	}
	public static void stampa(String s) {
		System.out.println(s);
	}
}
