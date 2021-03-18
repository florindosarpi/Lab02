package it.polito.tdp.alien;

import java.util.List;

public class WordEnhanced {
	
	private String alienWord;
	private List<String> translation;
	
	public WordEnhanced(String alienWord, List<String> translation) {
		super();
		this.alienWord = alienWord;
		this.translation = translation;
	}

	public String getAlienWord() {
		return alienWord;
	}

	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}

	public List<String> getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		boolean trovato = false;
		for (String s : this.translation) {
			if (s.equalsIgnoreCase(translation)) {
				trovato = true;
				break;
			}
		}
		if (trovato ==false)
			this.translation.add(translation);
	}
	
	

	@Override
	public String toString() {
		return "WordEnhanced [translation=" + translation + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alienWord == null) ? 0 : alienWord.hashCode());
		result = prime * result + ((translation == null) ? 0 : translation.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WordEnhanced other = (WordEnhanced) obj;
		if (alienWord == null) {
			if (other.alienWord != null)
				return false;
		} else if (!alienWord.equals(other.alienWord))
			return false;
		if (translation == null) {
			if (other.translation != null)
				return false;
		} else if (!translation.equals(other.translation))
			return false;
		return true;
	}
	

	
	

}
