package pl.training;

import java.util.Random;

public class Main {

	public static void main(String[] args) {

		// Klas� Main:
		//
		// - Utworzy� list�,
		// - Wy�wietli� liczb� element�w listy,
		// - Wy�wietli� list�,
		// - Wy�wietli� np. karty o warto�ci 12,
		// - Usun�� karty powtarzaj�ce si�,
		// - Wy�wietli� liczb� element�w listy,
		// - Wy�wietli� list�.

		ListaKart lista = new ListaKart();
		Random rand = new Random();

		for (int i = 0; i < 8; i++) {
			int wartosc = rand.nextInt(13);
			int kolor = rand.nextInt(4);
			lista.add(new Karta(wartosc, kolor));
		}

		lista.wyswietlLiczbeKart();
		lista.wyswietl();
	}
}
