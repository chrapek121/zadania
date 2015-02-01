package pl.training;

public class Lista implements ListaInterface {

	private Wezel pierwszy;

	@Override
	public boolean Pusta() {
		return pierwszy == null;
	}

	@Override
	public void DodajPierwszy(Karta value) {
		if (!Szukaj(value)) {
			Wezel temp = pierwszy;
			pierwszy = new Wezel(value, temp);
		}
	}

	@Override
	public void UsunPierwszy() {
		if (pierwszy != null) {
			pierwszy = pierwszy.next;
		}
	}

	public void Dodaj(Karta value) {
		if (!Szukaj(value)) {
			if (pierwszy == null) {
				pierwszy = new Wezel(value);
			} else {
				Wezel obecny = pierwszy;
				while (obecny.next != null) {
					obecny = obecny.next;
				}
				obecny.next = new Wezel(value);
			}
		}
	}

	@Override
	public void Usun(Karta value) {

		if (!Pusta()) {
			if (pierwszy.karta.equals(value)) {
				UsunPierwszy();
			} else {
				Wezel obecny = pierwszy;
				while (obecny.next != null) {
					if (obecny.next.karta.equals(value)) {
						obecny.next = obecny.next.next;
						break;
					}
					obecny = obecny.next;
				}
			}
		}
	}

	@Override
	public boolean Szukaj(Karta value) {
		if (!Pusta()) {
			Wezel obecny = pierwszy;

			do {
				if (obecny.karta.equals(value)) {
					return true;
				}
				obecny = obecny.next;
			} while (obecny != null);

		}
		return false;
	}

	@Override
	public void Wyswietl() {
		if (pierwszy != null) {
			Wezel obecny = pierwszy;
			while (obecny.next != null) {
				System.out.println(obecny);
				obecny = obecny.next;
			}
		}
	}

	@Override
	public int LiczbaElementow() {
		int length = 0;

		if (pierwszy != null) {
			Wezel obecny = pierwszy;
			while (obecny.next != null) {
				obecny = obecny.next;
				length++;
			}
		}
		return length;
	}

	@Override
	public void Kasuj() {

		if (!Pusta()) {
			pierwszy = null;

		}
	}

}
