package pl.training;

import java.util.ArrayList;
import java.util.List;

public class ListaKart implements Lista {

	private List<Karta> lista = new ArrayList<Karta>();

	public void insert(int i, Karta value) throws IndexOutOfBoundsException {
		if (!contains(value)) {
			lista.add(i, value);
		}
	}

	public void add(Karta value) {
		if (!contains(value)) {
			lista.add(value);
		}
	}

	public Karta delete(int i) throws IndexOutOfBoundsException {
		return lista.remove(i);
	}

	public boolean delete(Karta value) {
		return lista.remove(value);
	}

	public void clear() {
		lista.clear();
	}

	public Karta set(int i, Karta value) throws IndexOutOfBoundsException {
		return lista.set(i, value);
	}

	public Karta get(int i) throws IndexOutOfBoundsException {
		return lista.get(i);
	}

	public int indexOf(Karta value) {
		return lista.indexOf(value);
	}

	public boolean contains(Karta value) {
		return lista.contains(value);
	}

	public int size() {
		return lista.size();
	}

	public boolean isEmpty() {
		return lista.isEmpty();
	}

	public void wyswietl() {
		for (Karta karta : lista) {
			System.out.println(karta);
		}
	}

	public void wyswietlLiczbeKart() {
		System.out.println("liczba elementów listy " + size() + "\n");
	}

	public void wyswietlWartosc(int index) {
		System.out.println(get(index));
	}

}
