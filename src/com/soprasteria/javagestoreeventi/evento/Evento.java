package com.soprasteria.javagestoreeventi.evento;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.soprasteria.javagestoreeventi.exceptions.DataPassataException;
import com.soprasteria.javagestoreeventi.exceptions.NumeroPostiException;

public class Evento {
	
	private String titolo;
	private LocalDate data;
	private int numPostiTotale;
	private int numPostiPrenotati;
	
	public Evento(String titolo, LocalDate data, int numPostiTotale) throws DataPassataException, NumeroPostiException {
		super();
		this.titolo = titolo;
		if(data.isBefore(LocalDate.now())) {
			throw new DataPassataException("La data dell'evento è già passata!");
		} else {
			this.data = data;
		}
		if(numPostiTotale < 0) {
			throw new NumeroPostiException("Il numero di posti totali è negativo!");
		} else {
			this.numPostiTotale = numPostiTotale;
		}
		this.numPostiPrenotati = 0;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public int getNumPostiTotale() {
		return numPostiTotale;
	}

	public int getNumPostiPrenotati() {
		return numPostiPrenotati;
	}
	
	public void prenota() throws DataPassataException, NumeroPostiException {
		if(this.data.isBefore(LocalDate.now())) {
			throw new DataPassataException("l'evento è già passato!");
		} else if(this.numPostiTotale == this.numPostiPrenotati) {
			throw new NumeroPostiException("posti esauriti!");
		} else {
			this.numPostiPrenotati++;
		}
	}
	
	public void disdici() throws DataPassataException, NumeroPostiException {
		if(this.data.isBefore(LocalDate.now())) {
			throw new DataPassataException("l'evento è già passato!");
		} else if(this.numPostiPrenotati == 0) {
			throw new NumeroPostiException("tutti i posti sono liberi!");
		} else {
			this.numPostiPrenotati--;
		}
	}

	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "Titolo evento: " + getTitolo() + ", data: " + getData().format(dtf);
	}

	
	
}