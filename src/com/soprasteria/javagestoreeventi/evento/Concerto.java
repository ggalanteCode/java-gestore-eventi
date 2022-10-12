package com.soprasteria.javagestoreeventi.evento;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

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
		this.ora = ora;
		this.prezzo = prezzo;
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
	
	private String formattaDataEOra() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataFormattata = this.getData().format(dtf);
		dtf = DateTimeFormatter.ofPattern("hh:mm:ss");
		String oraFormattata = this.ora.format(dtf);
		return "data: " + dataFormattata + ", ora formattata" + oraFormattata;
	}
	
	private String formattaPrezzo() {
		DecimalFormat df = new DecimalFormat("##.## €");
		return "prezzo: " + df.format(this.getPrezzo());
	}

	@Override
	public String toString() {
		return formattaDataEOra() + ", " + getTitolo()+ ", " 
				+ formattaPrezzo();
	}

}
