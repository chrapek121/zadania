package mrowki;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(args[0]);
		Scanner in = new Scanner(file);

		String dane = in.nextLine();
		System.out.println(dane);

		String[] parts = dane.split(" ");
		Integer K = Integer.valueOf(parts[0]);
		Integer M = Integer.valueOf(parts[1]);
		Integer N = Integer.valueOf(parts[2]);

		Korytarz[] tunel = new Korytarz[K];
		for (int i = 0; i < K; i++) {
			tunel[i] = new Korytarz(M, i + 1);
		}

		for (int i = 0; i < N; i++) {
			String param = in.nextLine();
			String[] akcja = param.split(" ");
			Integer typAkcji = Integer.valueOf(akcja[0]);
			Integer nrKor = Integer.valueOf(akcja[1]);

			if (typAkcji == 1) {
				tunel[nrKor - 1].dodaj();
			} else {
				tunel[nrKor - 1].usun();
			}

		}
		in.close();

		for (int i = 0; i < tunel.length; i++) {
			tunel[i].wyswietl();
		}
	}
}
