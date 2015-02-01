package pl.training;

public class Wezel {

	public Karta karta;

	public Wezel next;

	public Wezel(Karta karta) {

		this.karta = karta;
	}

	public Wezel(Karta karta, Wezel next) {
		this.karta = karta;
		this.next = next;
	}

	@Override
	public String toString() {
		return karta.toString();
	}

}
