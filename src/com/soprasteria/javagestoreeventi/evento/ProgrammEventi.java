package com.soprasteria.javagestoreeventi.evento;

import java.time.LocalDate;
import java.util.ArrayList;
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

}
