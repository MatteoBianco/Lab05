package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {
	
	private List<String> soluzione;	
	private AnagrammaDAO aDAO;
	
	public Model() {
		
		aDAO = new AnagrammaDAO();
	}
	
	/**
	 * genera tutti gli anagrammi della parola passata come parametro, esclusi gli anagrammi ripetuti
	 * @param parola parola da anagrammare
	 * @return lista di anagrammi
	 */
	public List<String> anagramma(String parola){
		
		List<Character> lettere = new ArrayList<Character>();
		soluzione = new ArrayList<String>();
		parola = parola.toLowerCase();
		
		for(int i = 0; i < parola.length(); i++) {
			lettere.add(parola.charAt(i));
		}
		
		ricorsione("", 0, lettere);
		
		return soluzione;
	}
	
	/**
	 * procedura ricorsiva per creare gli anagrammi di una parola
	 * @param parziale parte iniziale dell'anagramma
	 * @param livello livello della ricorsione, uguale alla lunghezza della parola parziale
	 * @param lettere caratteri ancora disponibili per completare l'anagramma
	 */
	public void ricorsione(String parziale, int livello, List<Character> lettere) {
		
		if(lettere.isEmpty()) {
			if(!this.soluzione.contains(parziale))
				this.soluzione.add(parziale);
		}
		
		for(Character c : lettere) {
			
			String nuova = parziale + c;
			List<Character> rimanenti = new ArrayList<Character>(lettere);
			rimanenti.remove(c);
			
			ricorsione(nuova, livello + 1, rimanenti);
		}		
	}
	
	public boolean isCorrect(String anagramma) {
		return aDAO.isCorrect(anagramma);
	}
}
