package wybory_zygol;

public class Partia {
	int partia;
	int numer;

	Partia(int partia, int numer) {
		this.partia = partia;
		this.numer = numer;
	}

	public String wyswietl() {
		return partia + " " + numer;
	}
}
