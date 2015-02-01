package wybory;

public class Wezel {

	public Kandydat dane;
	public Wezel nast;

	public Wezel(Kandydat d) {
		this.dane = d;
	}

	public void wyswietl() {
		System.out.println(dane);
	}
}
