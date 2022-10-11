package com.soprasteria.javagestoreeventi;

import java.time.LocalDate;
import java.util.Scanner;

import com.soprasteria.javagestoreeventi.evento.Evento;
import com.soprasteria.javagestoreeventi.exceptions.DataPassataException;
import com.soprasteria.javagestoreeventi.exceptions.NumeroPostiException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String titolo;
		LocalDate data;
		int postiTotali, giorno, mese, anno;
		boolean prenotaODisdici;
		
		Scanner s = new Scanner(System.in);
		
		do {
			try {
				System.out.print("Nuovo evento:\nTitolo: ");
				titolo = s.nextLine();
				System.out.print("Data:\nGiorno: ");
				giorno = s.nextInt();s.nextLine();
				System.out.print("Mese: ");
				mese = s.nextInt();s.nextLine();
				System.out.print("Anno: ");
				anno = s.nextInt();s.nextLine();
				data = LocalDate.of(anno, mese, giorno);
				System.out.print("Posti totali: ");
				postiTotali = s.nextInt();s.nextLine();
				Evento evento = new Evento(titolo, data, postiTotali);
				System.out.println(evento);
				
				System.out.print("Vuoi prenotare dei posti per l'evento?: ");
				prenotaODisdici = s.nextBoolean();s.nextLine();
				if(prenotaODisdici) {
					System.out.print("Quanti posti vuoi prenotare?: ");
					int postiDaPrenotare = s.nextInt();s.nextLine();
					for(int i = 0; i < postiDaPrenotare; i++) {
						evento.prenota();
					}
				}
				System.out.println("Posti prenotati: " + 
						evento.getNumPostiPrenotati() + " Posti disponibili: "
						+ (evento.getNumPostiTotale()-evento.getNumPostiPrenotati()));
				System.out.print("Vuoi disdire dei posti?: ");
				prenotaODisdici = s.nextBoolean();s.nextLine();
				if(prenotaODisdici) {
					System.out.print("Quanti posti vuoi disdire?: ");
					int postiDaDisdire = s.nextInt();s.nextLine();
					for(int i = 0; i < postiDaDisdire; i++) {
						evento.disdici();
					}
				}
				System.out.println("Posti prenotati: " + 
						evento.getNumPostiPrenotati() + " Posti disponibili: "
						+ (evento.getNumPostiTotale()-evento.getNumPostiPrenotati()));
				break;
			} catch (DataPassataException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				System.err.println("reinserire i dati dell'evento...");
				System.err.println();
			} catch (NumeroPostiException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				System.err.println("reinserire i dati dell'evento...");
				System.err.println();
			}
		} while(true);
		
		s.close();
	}

}
