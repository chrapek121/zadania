package zdanie2;

public class Ksiazka {

	String tytul;
	String autor;
	String wydawnictwo;
	double cena;
	int rokWydania;

	public Ksiazka() {
		// empty
	}

	public Ksiazka(String tytul, String autor, String wydawnictwo, double cena, int rokWydania) {
		this.tytul = tytul;
		this.autor = autor;
		this.wydawnictwo = wydawnictwo;
		this.cena = cena;
		this.rokWydania = rokWydania;
	}

	public void wyswietl() {
		System.out.printf("%s \t| %s \t| %s \t\t| %f \t| %d \n", tytul, autor, wydawnictwo, cena, rokWydania);
	}

	public static void naglowek() {
		System.out.println("Tytu³ \t| Autor \t| Wydawnictwo \t| Cena \t\t| RokWydania \n");
	}

	@Override
	public String toString() {
		return String.format("Tytu³, Autor, Wydawnictwo, Cena, RokWydania\n %s, %s, %s, %f, %d \n", tytul, autor, wydawnictwo, cena, rokWydania);
	}

}
