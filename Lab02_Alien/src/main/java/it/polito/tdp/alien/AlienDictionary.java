package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {
	
	List<Word> dictionary;

	public AlienDictionary() {
		this.dictionary = new ArrayList<>();
	}
	
	public void addWord(String alienWord, String translation) {
		boolean trovato = false;
		for (Word w : dictionary) {
			if(w.getAlienWord().equalsIgnoreCase(alienWord))
			{
				w.setTranslation(translation);
				trovato = true;
				break ; 
			}
		}
		if (trovato == false) {
			dictionary.add(new Word(alienWord, translation));
		}
	}
	
	public String translateWord(String alienWord) {
		for (Word w : dictionary) {
			if(w.getAlienWord().equalsIgnoreCase(alienWord))
			{
				return w.getTranslation() ; 
			}
		}
		return null;
		
	}
	
	

}
