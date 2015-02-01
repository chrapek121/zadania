package wybory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WyborySejmu {

	public static void main(String[] args) throws FileNotFoundException,
			ClosedListException, NoKandydatLeftException {
		File file = new File("WB2.txt");
		Scanner in = new Scanner(file);

		String dane = in.nextLine();
		System.out.println(dane);

		String[] parts = dane.split(" ");
		Integer N = Integer.valueOf(parts[0]);
		Integer M = Integer.valueOf(parts[1]);

		int R = (N + M) / (N * N);
		int sumaL = 0;
		ListaWyborcza listaKandydatow = new ListaWyborcza();
		int[] listaPartii = new int[N];
		for (int i = 0; i < N; i++) {

			String part1 = in.nextLine();
			Integer KI = Integer.valueOf(part1);
			int LI = (M - N) * KI / 100 + 1;
			sumaL += LI;
			listaPartii[i] = LI;
			System.out.println("liczba kandydatow partii " + i + ": " + LI);
		}

		listaPartii[0] = listaPartii[0] + M - sumaL;
		System.out.println("liczba kandydatow partii 1 :" + listaPartii[0]);

		for (int i = 0; i < listaPartii.length; i++) {
			int dodawanieKandydatow = listaPartii[i];

			for (int j = 1; j < dodawanieKandydatow; j++) {
				listaKandydatow.dodaj(new Kandydat(i + 1, j + 1));
			}
		}

		listaKandydatow.zamknijListe();

		String prezydent = in.nextLine();
		in.close();
		Integer P = Integer.valueOf(prezydent);
		ListaWyborcza listaPoslow = new ListaWyborcza();

		for (int i = 0; i < N; i++) {
			listaPoslow.dodaj(new Kandydat(i + 1, 1));
		}

		for (int i = N; i < R; i++) {
			listaPoslow.dodaj(listaKandydatow.usun(P));
		}
		listaPoslow.zamknijListe();

		for (int i = 0; i < R - 1; i++) {
			listaPoslow.usun(P);
		}

		System.out.println("Liczba czlonkow rzadu: " + R);
		System.out.println("Liczba prezydenta: " + P);
		System.out.println("Suma kandydatow: " + sumaL);

		System.out.println("Premier: " + listaPoslow.usun(0));
	}
}
