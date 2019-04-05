package it.polito.tdp.spellchecker.model;

public class RichWord {
	
	public RichWord(String word, boolean correct) {
		super();
		this.word = word;
		this.correct = correct;
	}
	
	String word;
	boolean correct;
	
	
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public boolean isCorrect() {
		return correct;
	}
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

	
}
