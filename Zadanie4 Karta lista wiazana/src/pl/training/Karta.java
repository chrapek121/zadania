package pl.training;

public class Karta {

	private int wartosc;
	private int kolor;
	private String[] colorName = { "kier", "karo", "trefl", "pik" };
	private String[] valueName = { "as", "2", "3", "4", "5", "6", "7", "8", "9", "10", "walet", "dama", "król" };

	public Karta() {
		// empty
	}

	public Karta(int wartosc, int kolor) {
		this.wartosc = wartosc;
		this.kolor = kolor;
	}

	

	public String toString() {
		return String.format(" %s %s", valueName[wartosc], colorName[kolor]);
	}

	
}
