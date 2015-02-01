package wybory;

public class Kandydat {

	private int nrPartii;
	private int liczbaKandydatow;

	public Kandydat(int nrPartii, int liczbaKandydatow) {
		this.nrPartii = nrPartii;
		this.liczbaKandydatow = liczbaKandydatow;
	}

	public int getN() {
		return nrPartii;
	}

	public void setN(int n) {
		nrPartii = n;
	}

	public int getLI() {
		return liczbaKandydatow;
	}

	public void setLI(int lI) {
		liczbaKandydatow = lI;
	}

	@Override
	public String toString() {
		return String.format(" %d %d", nrPartii, liczbaKandydatow);
	}

}
