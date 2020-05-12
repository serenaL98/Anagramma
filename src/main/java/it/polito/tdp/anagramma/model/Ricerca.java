package it.polito.tdp.anagramma.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Ricerca {
	
	private List<String> soluzione ;

	/**
	 * Genera tutti gli anagrammi della parola specificata in ingresso.
	 * @param parola parola da anagrammare
	 * @return elenco di tutti gli anagrammi della parola data
	 */
	public List<String> anagrammi(String parola) {
		this.soluzione = new ArrayList<>();
		
		//all'inizio si troverà così la ricorsione
		parola = parola.toUpperCase();	//per evitare problemi
		List<Character> disponibili = new ArrayList<>();
		for(int i=0; i<parola.length(); i++) {
			disponibili.add(parola.charAt(i));
		}
		//avvio ricorsione: preparazione delle variabili in via della ricorsione stessa
		cerca("", 0, disponibili);
		
		return this.soluzione;
	}
	
	//Procedura ricorsiva
	//l'ambiente dove i parametri sono gia creati si ricavano del metodo privato cerca
		//parziale: partre dell'anagramma scritto finora
		//livello: livello della ricorsione, sempre uguale alla lunghezza della parziale
		//disponibili: insieme di caratteri non ancora utilizzati
	private void cerca(String parziale, int livello, List<Character> disponibili) {
		if(disponibili.size()==0) {
			//caso terminale: il livello è uguale alla lunghezza della parola dad cercare || quando non c'è nessuna lettera da aggiungere
			//if(parziale è nel dizionario allora la stampo) altrimenti la scarto
			//if parziale non è prenìsente nella soluzione eseguo, altrimenti non la inserisco di nuovo
			this.soluzione.add(parziale);
		}
		//caso normale: provare ad aggiungere alla soluzione parziale tutti i carrateri presenti tra i disponibili
		for(Character ch: disponibili) {
			//if(nel dizionario esistono parole = tentativo)
				//eseguo
			//else
				//esco perchè è inutile fare una funzione se non esiste la parola
			//nuova stringa in cui aggiungo alla stringa parziale un carattere disponibile (non uso il backtracking perchè non modifico la stringa parziale)
			String tentativo = parziale + ch;
			
			//dato che sto iterando dentro disponibili, non posso rimuovere il carattere aggiunto direttamente dalla lista disponibili
			//faccio una copia della lista per poter rimuovere la lettera da lì
			List<Character> rimanenti = new ArrayList<Character>(disponibili);
			rimanenti.remove(ch);
			
			cerca(tentativo, livello+1, rimanenti);
		}
	}
	

/*DATO DI PARTENZA: parola di lunghezza N
 * Domande:
 * 1- cos'è la soluzione parziale?	parte dell'anagramma gia costruito (i primi caratteri: dalla prima lettera in avanti)
 * il livello mi indica il numero di lettere di cui è composta la parola
 * SOLUZIONE FINALE: soluzione di lunghezza N--> sono nel caso terminale: salvo la soluzione trovata per poterla poi restituire
 * DENTRO LA RICORSIONE: ho una soluzione parziale devo generare una nuova soluzione con una lettera in piu, scegliendola
 * 	tra quelle non ancora utilizzate nella soluzione parziale
 * 
 * */
}