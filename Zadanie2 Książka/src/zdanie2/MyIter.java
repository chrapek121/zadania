package zdanie2;

import java.util.List;

public class MyIter implements Iterator2 {

	List<Ksiazka> listaKasiazek;
	int index = 0;

	public MyIter(List<Ksiazka> listaKasiazek) {
		this.listaKasiazek = listaKasiazek;
	}

	public void poprzedni() {
		index--;

	}

	public void nastepny() {
		index++;

	}

	public void pierwszy() {
		index = 0;

	}

	public void ostatni() {
		listaKasiazek.size();

	}

	public boolean jestWZakresie() {

		return index >= 0 && index < listaKasiazek.size();
	}

	public Ksiazka elementBiezacy() {
		return listaKasiazek.get(index);
	}

}
