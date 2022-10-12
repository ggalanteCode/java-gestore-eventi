package com.soprasteria.javagestoreeventi.evento;

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

}
