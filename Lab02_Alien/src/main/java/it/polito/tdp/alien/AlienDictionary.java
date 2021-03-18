package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {
	
	List<WordEnhanced> dictionary;

	public AlienDictionary() {
		this.dictionary = new ArrayList<>();
	}
	
	public void addWord(String alienWord, String translation) {
		boolean trovato = false;
		for (WordEnhanced w : dictionary) {
			if(w.getAlienWord().equalsIgnoreCase(alienWord))
			{
				w.setTranslation(translation);
				trovato = true;
				break ; 
			}
		}
		if (trovato == false) {
			List<String> nuovaTraduzione = new ArrayList<>();
			nuovaTraduzione.add(translation);
			dictionary.add(new WordEnhanced(alienWord, nuovaTraduzione));
		}
	}
	
	public String translateWord(String alienWord) {
		for (WordEnhanced w : dictionary) {
			if(w.getAlienWord().equalsIgnoreCase(alienWord))
			{
				return w.getTranslation().toString() ; 
			}
		}
		return null;
		
	}
	
	

}
