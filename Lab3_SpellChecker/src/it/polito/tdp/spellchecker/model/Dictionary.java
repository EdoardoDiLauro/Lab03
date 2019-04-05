package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dictionary {
	
	ArrayList<String> dictionary = new ArrayList<String>();
	
	public void loadDictionary (String language) {
		dictionary.clear();
		try {
			FileReader fr = new FileReader("rsc/English.txt");
			BufferedReader br = new BufferedReader(fr);
			String word;
			while ((word = br.readLine()) != null) {
				dictionary.add(word);
			}
			br.close();
			 } catch (IOException e){
			System.out.println("Errore nella lettura del file");
			}

	}
	
	public List<RichWord> spellCheckText(List<String> inputTextList){
		List<RichWord> spellChecked = new ArrayList<RichWord>();
		for (String s : inputTextList) {
			RichWord w = new RichWord (s, false);
			if (dictionary.contains(s)) w.setCorrect(true);
			else spellChecked.add(w);
		}
		return spellChecked;
	}
	
	public String spellCheckToString(List<String> inputTextList){
		StringBuilder sb = new StringBuilder();
		List<RichWord> checkedRW = this.spellCheckText(inputTextList);
		for (RichWord rw : checkedRW) sb.append(rw.getWord() + "\n");
		return sb.toString();
	}

}
