package wybory;

public class ListaWyborcza {

	private Wezel pierwszy;

	private boolean isListClosed = false;

	public void dodaj(Kandydat k) throws ClosedListException {
		if (isListClosed) {
			throw new ClosedListException(
					"List is closed, cannot add more kandydata.");
		}

		if (pierwszy == null) {
			Wezel obecnyPierwszy = pierwszy;
			pierwszy = new Wezel(k);
			pierwszy.nast = obecnyPierwszy;

		} else {
			Wezel current = pierwszy;
			while (current.nast != null) {

				current = current.nast;
			}
			current.nast = new Wezel(k);
		}
	}

	private void usun(Kandydat k) {
		if (pierwszy != null) {
			if (pierwszy.dane.equals(k)) {
				pierwszy = pierwszy.nast;

			}

			Wezel current = pierwszy;

			while (current.nast != null && !current.nast.equals(pierwszy)) {
				if (current.nast.dane.equals(k)) {
					current.nast = current.nast.nast;
					break;
				}
				current = current.nast;
			}

		}
	}

	public void zamknijListe() {
		if (pierwszy != null) {

			Wezel current = pierwszy;
			while (current.nast != null && !current.nast.equals(pierwszy)) {
				current = current.nast;
			}
			current.nast = pierwszy;
			isListClosed = true;
		}
	}

	public Kandydat usun(int step) throws NoKandydatLeftException {
		if (pierwszy == null) {
			throw new NoKandydatLeftException("There is no more kandydata");
		}

		for (int i = 1; i < step; i++) {
			pierwszy = pierwszy.nast;
		}
		Kandydat temp = pierwszy.dane;
		usun(temp);
		return temp;

	}

	@Override
	public String toString() {
		Wezel current = pierwszy;
		String candidateList = "{" + current.dane;
		while (current.nast != null && !current.nast.equals(pierwszy)) {
			current = current.nast;
			candidateList += "," + current.dane;
		}
		candidateList += "}";

		return candidateList;
	}

}
