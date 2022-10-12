package com.soprasteria.javagestoreeventi.evento;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProgrammEventi {
	
	private String titolo;
	private List<Evento> eventi;
	
	public ProgrammEventi(String titolo) {
		super();
		this.titolo = titolo;
		this.eventi = new ArrayList<Evento>();
	}
	
	public void aggiungiEvento(Evento evento) {
		this.eventi.add(evento);
	}
	
	public List<Evento> getEventiInData(LocalDate data) {
		ArrayList<Evento> eventiInData = new ArrayList<Evento>();
		for(int i = 0; i < eventi.size(); i++) {
			if(eventi.get(i).getData().equals(data)) {
				eventiInData.add(eventi.get(i));
			}
		}
		return eventiInData;
	}
	
	public int numeroEventi() {
		return this.eventi.size();
	}
	
	public void svuotaListaEventi() {
		this.eventi.clear();
	}
	
	private void ordinaListaEventi() {
		//IMPLEMENTAZIONE DELL'INSERTION SORT
		//https://it.wikipedia.org/wiki/Insertion_sort
		Evento e; int j; Evento[] arrayEventi = new Evento[eventi.size()];
		arrayEventi = eventi.toArray(arrayEventi);
		for(int i = 0; i < arrayEventi.length; i++) {
			e = arrayEventi[i];
			j = i-1;
			while(j >= 0 && arrayEventi[j].compareTo(e) > 0) {
				arrayEventi[j+1] = arrayEventi[j];
				j--;
			}
			arrayEventi[j+1] = e;
		}
		eventi = Arrays.asList(arrayEventi);
	}

	@Override
	public String toString() {
		this.ordinaListaEventi(); String elencoEventi = "";
		for(int i = 0; i < eventi.size(); i++) {
			elencoEventi += eventi.get(i).toString() + "\n";
		}
		return "Titolo del programma: " + titolo + "\nEventi:\n"
				+ elencoEventi;
	}
	
	

}
