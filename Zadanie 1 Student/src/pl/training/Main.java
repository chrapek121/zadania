package pl.training;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Student[] daneStudentow = stworzStudentow();
		wyswietlStudentow(daneStudentow);
		zapiszStudrntowDoPloku(daneStudentow);
	}

	private static Student[] stworzStudentow() {
		Scanner dane = new Scanner(System.in);
		System.out.println("Podaj ilo�� student�w");
		int iloscStudentow = dane.nextInt();

		Student[] daneStudentow = new Student[iloscStudentow];

		for (int i = 0; i < daneStudentow.length; i++) {
			System.out.println("Podaj nazwisko");
			String nazwisko = dane.next();
			System.out.println("Podaj imi�");
			String imie = dane.next();
			System.out.println("Podaj numer albumu");
			long album = dane.nextLong();
			System.out.println("Podaj rok studi�w");
			int rok = dane.nextInt();
			System.out.println("Podaj �redni� z ostatniego semestru");
			double srednia = dane.nextDouble();

			daneStudentow[i] = new Student(nazwisko, imie, album, rok, srednia);
		}
		dane.close();

		return daneStudentow;
	}

	private static void wyswietlStudentow(Student[] daneStudentow) {
		for (int i = 0; i < daneStudentow.length; i++) {
			daneStudentow[i].wyswietl();
		}
	}

	private static void zapiszStudrntowDoPloku(Student[] daneStudentow) throws FileNotFoundException {
		PrintWriter zapis = new PrintWriter("dane_studentow.txt");

		for (int i = 0; i < daneStudentow.length; i++) {
			zapis.println(daneStudentow[i]);
		}

		zapis.close();
	}
}
