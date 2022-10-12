package com.soprasteria.javagestoreeventi.evento;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import com.soprasteria.javagestoreeventi.exceptions.DataPassataException;
import com.soprasteria.javagestoreeventi.exceptions.NumeroPostiException;

public class Concerto extends Evento {
	
	private LocalTime ora;
	private BigDecimal prezzo;

	public Concerto(String titolo, LocalDate data, int numPostiTotale,
			LocalTime ora, BigDecimal prezzo)
			throws DataPassataException, NumeroPostiException {
		super(titolo, data, numPostiTotale);
		// TODO Auto-generated constructor stub
		
	}

	public LocalTime getOra() {
		return ora;
	}

	public void setOra(LocalTime ora) {
		this.ora = ora;
	}

	public BigDecimal getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}

}
