package pl.training;

import java.util.Random;

public class Main {

	public static void main(String[] args) {

		// Klasê Main:
		//
		// - Utworzyæ listê,
		// - Wyœwietliæ liczbê elementów listy,
		// - Wyœwietliæ listê,
		// - Wyœwietliæ np. karty o wartoœci 12,
		// - Usun¹æ karty powtarzaj¹ce siê,
		// - Wyœwietliæ liczbê elementów listy,
		// - Wyœwietliæ listê.

		ListaInterface lista = new Lista();
		Random rand = new Random();

		for (int i = 0; i < 8; i++) {
			int wartosc = rand.nextInt(13);
			int kolor = rand.nextInt(4);
			lista.Dodaj(new Karta(wartosc, kolor));
		}

		lista.Wyswietl();
	}
}
