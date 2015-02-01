package pl.training;

public class Student {

	String nazwisko;
	String imie;
	long album;
	int rok;
	double srednia;

	public Student() {
		// empty
	}

	public Student(String nazwisko, String imie, long album, int rok, double srednia) {
		this.nazwisko = nazwisko;
		this.imie = imie;
		this.album = album;
		this.rok = rok;
		this.srednia = srednia;
	}

	public void wyswietl() {
		System.out.printf("Nazwisko: %s, Imie: %s, Album: %d, Rok: %d, Srednia: %f\n", nazwisko, imie, album, rok, srednia);
	}

	@Override
	public String toString() {
		return String.format("Nazwisko: %s, Imie: %s, Album: %d, Rok: %d, Srednia: %f", nazwisko, imie, album, rok, srednia);
	}

}
