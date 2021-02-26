import java.util.*;

public class Project {
	int ID_Project;
	String Titolo;
	Date Inizio;
	/* Enum */ String Ambito;
	/* Enum */ String Tipo;
	String Descrizione;
	float Budget;
	boolean State;
	ArrayList<User> membri;
	
	public Project(int ID) {
		Scanner in = new Scanner(System.in);
		ID_Project = ID;
		System.out.println("inserisci Titolo progetto");
		Titolo = in.next();
		System.out.println("inserisci Ambito progetto");
		Ambito = in.next();
		System.out.println("inserisci Tipo progetto");
		Tipo = in.next();
		System.out.println("inserisci una descrizione (facoltativo)");
		Descrizione = in.next();
		System.out.println("imposta un budget");
		// catch if budget is NOT FLOAT
		Budget = in.nextFloat();
	}
	public void getInfo() {
		String Scelta;
		Scanner in = new Scanner(System.in);
		System.out.println("Titolo : " + Titolo);
		System.out.println("Ambito : " + Ambito);
		System.out.println("Tipo : " + Tipo);
		System.out.println("Descrizione : " + Descrizione);
		System.out.println("Budget : " + Budget);
		System.out.println("Vuoi stampare la lista membri? S/N");
		// catch if scelta IS NOT S/N
		Scelta = in.next();
		if(Scelta.contentEquals("S")) {
			StampaMembri();
		}
		

	}
	public static void StampaInfoProgetti(ArrayList<Project> Item){
		//query di ricerca per  progetti solo attivi, solo completati etc etc etc etc
		for(int i=0 ; i < Item.size() ; i++ ) {
			System.out.println(i + ") ");
			Item.get(i).getInfo();
		}
	}
	public void setState() {
		if (State == false) {
			State = true;
			System.out.println("Stato impostato su 'Terminato'");
		}
		else {
			State = false;
			System.out.println("Stato impostato su 'Attivo' ");
		}
		
	//imposta lo stato attuale del progetto
	}
	public void ModifyMembers() {
	// add e delete di membri dal gruppo tramite ricerca o selezione da lista
		Scanner in = new Scanner(System.in);
		boolean exit = true;
		int scelta;
		while (exit) {
			System.out.println("Menù di gestione partecipanti al progetto, che operazione vuoi compiere? ");
			System.out.println(" 1) Stampa lista membri ");
			System.out.println(" 2) Aggiungi membro "); //aggiunta con scelta dalla lista di ogni membro che non sia già aggiunto
			System.out.println(" 3) Elimina membro ");
			System.out.println(" 0) Esci ");
			scelta = in.nextInt();
			switch(scelta){
			case 0 : 
				exit=false; break;
			case 1 :
				StampaMembri(); break;
			case 2 : 
				// selezione dai membri attivi
			case 3 : 
				// selezione dai membri del gruppo attuale
			default : //throw exception
				System.out.println("Errore, riprovare");
			}
		}
	}
	public void StampaMembri() {
		System.out.println("Prova");
	}
	public static int addProjects(int ActiveID, ArrayList<Project> Progetti){
		Scanner in = new Scanner(System.in);
		int num;
		System.out.println("Quanti progetti vuoi inserire all'interno del dbase ? ");
		num = in.nextInt();
		for(int i = 0; i < num; i++ ) {
			ActiveID++;
			Progetti.add(new Project(ActiveID));
		}
		return ActiveID;
	}
	public static void modificaProgetto(ArrayList<Project> list , int Key) {
		Scanner in = new Scanner(System.in);
		int scelta,scelta2;
		String prompt;
		float modify;
		boolean stat1 = true, stat2 = true;
		while(stat1) {
			System.out.println("progetto selezionato, cosa vuoi fare? ");
			System.out.println("1) Modifica progetto ");
			System.out.println("2) Elimina progetto ");
			System.out.println("0) Torna indietro ");
			scelta = in.nextInt();
			switch(scelta) {
			case 1:
				while(stat2) {
					System.out.println("Quale informazione del progetto vuoi modificare? ");
					System.out.println("1) Titolo ");
					System.out.println("2) Ambito");
					System.out.println("3) Tipo");
					System.out.println("4) Descrizione");
					System.out.println("5) Budget");
					System.out.println("6) Status");
					System.out.println("7) Membri");
					System.out.println("0) Torna Indietro");
					scelta2=in.nextInt();
					switch(scelta2) {
					case 1:
						System.out.println("Inserisci il nuovo Titolo : (N per annullare)");
						prompt=in.next();
						if(prompt.contentEquals("N")) stat2 = false;
						else list.get(Key).Titolo = prompt;
						break;
					case 2:
						System.out.println("Inserisci il nuovo Ambito : (N per annullare)");
						prompt=in.next();
						if(prompt.contentEquals("N")) stat2 = false;
						else list.get(Key).Ambito = prompt;
						break;
					case 3:
						System.out.println("Inserisci il nuovo Tipo : (N per annullare)");
						prompt=in.next();
						if(prompt.contentEquals("N")) stat2 = false;
						else list.get(Key).Tipo = prompt;
						break;
					case 4:
						System.out.println("Inserisci la nuova Descrizione : (N per annullare)");
						prompt=in.next();
						if(prompt.contentEquals("N")) stat2 = false;
						else list.get(Key).Descrizione = prompt;
						break;
					case 5:
						System.out.println("Inserisci il nuovo Budget : (-1 per annullare)");
						modify = in.nextFloat ();
						if(modify == -1) stat2 = false;
						else list.get(Key).Budget = modify ;
						break;
					case 6:
						list.get(Key).setState();
						break;
					case 7:
						//Placeholder modifica membri
						break;
					case 0:
						stat2 = false;
						break;
					default :
					}
				}
				break;
			case 2:
				System.out.println("ne sei sicuro? S/N ");
				prompt = in.next();
				if(prompt.contentEquals("S")) {
					list.remove(Key);
					stat1 = false;
				}else stat1 = false;
				break;
			case 0:
				stat1 = false;
				break;
			default:
				System.out.println("Selezione errata, riprovare !");
			}
		}
	}
	public static int SceltaProj(ArrayList<Project> list){
		// scelta da lista completa o ricerca per titolo del progetto / ID
		boolean menu = true;
		String Key;
		Scanner in = new Scanner(System.in);
		int scelta,contatore=0,IDKEY;
		int sceltaproj=-1;
		while(menu) {
		System.out.println("/// Menù di ricerca progetti ///");
		System.out.println("Selezionare il metodo di ricerca :");
		System.out.println("1) Ricerca da Lista completa");
		System.out.println("2) Ricerca per Titolo");
		System.out.println("3) Ricerca per ID");
		System.out.println("0) Esci ");
		scelta = in.nextInt();
		switch(scelta) {
		case 0:
			menu = false;
			break;
			// scelta da lista
		case 1:
			for(int i=0 ; i<list.size() ; i++) {
				System.out.println(i+") "+list.get(i).Titolo);
			}
			System.out.println("seleziona il progetto che desideri modificare");
			sceltaproj = in.nextInt();
			menu = false;
			break;
			// ricerca per titolo
		case 2:
			System.out.println("Inserisci il titolo del progetto che cerchi :");
			Key = in.next();
			for(int i=0 ; i<list.size() ; i++) {
				if(list.get(i).Titolo.contains(Key)){
					System.out.println("riscontro in progetto " + i + ")" );
					list.get(i).getInfo();
					contatore++;
				}
				if(contatore>1) {
					System.out.println("a quale progetto vuoi accedere ?");
				// controllo degli id generati dalla ricerca parziale
					sceltaproj=in.nextInt();
				}
			}
			menu = false;
			break;
		case 3:
			// ricerca per id progetto ASSUMING id project conosciuto
			System.out.println("inserisci l'id del progetto che stai cercando : ");
			IDKEY = in.nextInt();
			for(int i=0 ; i<list.size() ; i++) {
				if(list.get(i).ID_Project==IDKEY) {
					System.out.println("progetto trovato ");
					list.get(i).getInfo();
					sceltaproj = i;
				}
			}
			menu = false;
			break;
			default:
			}
		}
		return sceltaproj;
	}
	
	//add e delete gestiti da main
}
