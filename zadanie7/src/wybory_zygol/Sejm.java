package wybory_zygol;

/**
 * 
 * Author: Zygmunt Horodyski
 * 
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Sejm {

	private Kolejka[] partia;
	private Kolejka rzad = new Kolejka();
	private int[] procenty;

	private int n, p, m;
	private String linia;
	BufferedReader in;

	public Sejm(String s) throws IOException {
		in = new BufferedReader(new FileReader(s));

		linia = in.readLine();
		String[] dane = linia.split(" ");

		n = Integer.parseInt(dane[0]); // ilosc parti
		m = Integer.parseInt(dane[1]); // liczba pos³ów

		System.out.println(s + "\n");

		partia = new Kolejka[n];
		procenty = new int[n];

		for (int i = 0; i < n; i++) {
			partia[i] = new Kolejka();

			linia = in.readLine();
			dane = linia.split(" ");
			procenty[i] = Integer.parseInt(dane[0]); // udzia³ procentowy partii
		}

		linia = in.readLine();
		dane = linia.split(" ");

		p = Integer.parseInt(dane[0]); // ilosc cz³onków rz¹du
	}

	public void symulacja() {
		wybory();
		rzad();
		premier();
	}

	private void wybory() {

		// przydzielanie miejsc w sejmie;
		int temp = 0;
		for (int i = 0; i < n; i++) {
			temp = (((m - (i + 1)) * procenty[i]) / 100) + 1;
			for (int j = 0; j < temp; j++)
				partia[i].add(new Partia(i + 1, j + 1));
		}

		// zliczanie ile miejsc zostalo przyznanych
		temp = 0;
		for (int i = 0; i < n; i++) {
			temp += partia[i].size();
		}

		// dodawanie niedomiaru na korzyszæ parti 1
		int temp2 = m - temp;
		temp = partia[0].size() + 1;
		for (int i = 0; i < temp2; i++, temp++) {
			partia[0].add(new Partia(1, temp));
		}
		/*
		 * for(int i = 0; i < n; i++){ partia[i].temp = partia[i].first; for(int
		 * j = 0; j < partia[i].size(); j++, partia[i].temp =
		 * partia[i].temp.next){ Partia part = (Partia)partia[i].temp.item;
		 * System.out.println(part.wyswietl()); System.out.println(); } }
		 */

	}

	private void rzad() {
		int r = (m + n) / (n * n);
		Kolejka kandydaci = new Kolejka();

		// dodaje parlamentarzystów do kolejki
		for (int i = 0; i < n; i++) {
			partia[i].temp = partia[i].first.next;
			for (int j = 1; j < partia[i].size(); j++, partia[i].temp = partia[i].temp.next) {
				kandydaci.add(partia[i].temp.item);
			}
		}

		// dodaje liderów do rzadu
		for (int i = 0; i < n; i++) {
			rzad.add(partia[i].first.item);
			partia[i].first.rzad = true;
			r--;
		}

		/*
		 * //tworzenie rzadu int temp = 0; kandydaci.temp = kandydaci.first;
		 * while(temp != r){ for(int i = 0; i < p; i++) kandydaci.temp =
		 * kandydaci.temp.next; if(kandydaci.temp.rzad != true){
		 * rzad.add(kandydaci.temp.item); r--; temp = 0; kandydaci.temp =
		 * kandydaci.temp.next; } else temp++; if(temp >= 2); }
		 */

		kandydaci.temp = kandydaci.first;
		while (r != 0) {
			for (int i = 1; i < p; i++)
				kandydaci.temp = kandydaci.temp.next;
			rzad.add(kandydaci.remove());

			r--;
			kandydaci.temp = kandydaci.temp.next;
		}

		/*
		 * rzad.temp = rzad.first; for(int j = 0; j < rzad.size(); j++,
		 * rzad.temp = rzad.temp.next){ Partia part = (Partia)rzad.temp.item;
		 * System.out.println(part.wyswietl()); }
		 */
	}

	private void premier() {
		Kolejka kandydaci = new Kolejka();

		// dodawanie kandydatów
		rzad.temp = rzad.first;
		for (int j = 0; j < rzad.size(); j++, rzad.temp = rzad.temp.next)
			kandydaci.add(rzad.temp.item);

		/*
		 * kandydaci.temp = kandydaci.first; for(int j = 0; j <
		 * kandydaci.size(); j++, kandydaci.temp = kandydaci.temp.next){ Partia
		 * part = (Partia)kandydaci.temp.item;
		 * System.out.println(part.wyswietl()); } System.out.println();
		 */

		// wybory premiera
		kandydaci.temp = kandydaci.first;
		while (kandydaci.size() != 1) {
			for (int i = 0; i < p; i++)
				kandydaci.temp = kandydaci.temp.next;
			kandydaci.temp = kandydaci.temp.previous;
			kandydaci.remove();
			kandydaci.temp = kandydaci.temp.next;
		}

		kandydaci.temp = kandydaci.temp.next;
		Partia part = (Partia) kandydaci.temp.item;
		System.out.println(part.wyswietl());
	}
}
