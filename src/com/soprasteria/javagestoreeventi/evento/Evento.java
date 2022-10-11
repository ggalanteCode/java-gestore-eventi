package com.soprasteria.javagestoreeventi.evento;

import java.time.LocalDate;

import com.soprasteria.javagestoreeventi.exceptions.DataPassataException;
import com.soprasteria.javagestoreeventi.exceptions.NumeroPostiNegativoException;

public class Evento {
	
	private String titolo;
	private LocalDate data;
	private int numPostiTotale;
	private int numPostiPrenotati;
	
	public Evento(String titolo, LocalDate data, int numPostiTotale) throws DataPassataException, NumeroPostiNegativoException {
		super();
		this.titolo = titolo;
		if(data.isBefore(LocalDate.now())) {
			throw new DataPassataException("La data dell'evento è già passata!");
		} else {
			this.data = data;
		}
		if(numPostiTotale < 0) {
			throw new NumeroPostiNegativoException("Il numero di posti totali è negativo!");
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
	
}