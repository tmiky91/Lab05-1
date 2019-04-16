package it.polito.tdp.anagrammi.model;

import java.util.HashSet;
import java.util.Set;

public class Model {
	
	public Set<String> calcolaAnagramma(String intera){
		Set<String> anagrammi = new HashSet<String>();
		String parziale="";
		calcola(parziale, intera, 0, anagrammi);
		return anagrammi;
	}
	
	public void calcola(String parziale, String intera, int livello, Set<String> anagrammi) {
		if(livello==intera.length()) {
			anagrammi.add(parziale);
			return;
		}
		
		for(int i=0; i<intera.length(); i++) {
			parziale+=intera.charAt(i);
			if(conta(parziale, intera.charAt(i))<=conta(intera, intera.charAt(i))) {
				calcola(parziale, intera, livello+1, anagrammi);
			}
			parziale=parziale.substring(0, parziale.length()-1);
			
		}
	}
	
	private static int conta(String string, char c) {
		int count =0;
		for(int i=0; i<string.length(); i++) {
			if(string.charAt(i)==c) {
				count++;
			}
		}
		return count;
	}

}
