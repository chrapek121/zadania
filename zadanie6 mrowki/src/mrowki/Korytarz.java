package mrowki;

import java.util.ArrayList;
import java.util.List;

public class Korytarz {

	private List<Integer> paczka = new ArrayList<Integer>();

	private int max;
	private int nrTunelu;
	int index = 0;

	public Korytarz(int max, int nrTunelu) {
		this.max = max;
		this.nrTunelu = nrTunelu;

	}

	public void dodaj() {
		if (paczka.size() < max) {
			paczka.add(++index);
		} else {
			System.out.print("Tunel pelny " + nrTunelu + ".");
			for (int i = 0; i < paczka.size(); i++) {
				System.out.print(" " + paczka.get(i));
			}
			System.out.println();
		}

	}

	public void usun() {
		if (!paczka.isEmpty()) {
			paczka.remove(0);
		} else {
			System.out.println("Tunel pusty " + nrTunelu);
		}
	}

	public void wyswietl() {
		System.out.print(nrTunelu + ". " + (index - paczka.size()) + ":");
		for (int i = 0; i < paczka.size(); i++) {
			System.out.print(" " + paczka.get(i));
		}
		System.out.println();

	}

}
