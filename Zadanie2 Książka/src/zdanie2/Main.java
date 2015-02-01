package zdanie2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//Z2. Dla klasy z zadania 1 zdefiniuj klasê Main. W tej klasie zadeklaruj obiekt sklep typu 
//ArrayList i wstaw kilka obiektów typu Ksiazka. Wyœwietl wszystkie wpisane dane do sklepu. 

public class Main {

	private static final String PWN = "PWN";

	public static void main(String[] args) {

		List<Ksiazka> sklep = new ArrayList<Ksiazka>();
		sklep.add(new Ksiazka("On", "Orzeszek", PWN, 22.5, 2010));
		sklep.add(new Ksiazka("Ona", "Orzeszkowa", PWN, 19.5, 1988));
		sklep.add(new Ksiazka("Ono", "Orzech", PWN, 209, 2011));
		sklep.add(new Ksiazka("Oni", "Orzeszkowski", PWN, 25.5, 2031));
		sklep.add(new Ksiazka("One", "Orzeszki", PWN, 208, 2000));

		Ksiazka.naglowek(); // wywolanie metody statycznej naglowek()

		for (int i = 0; i < sklep.size(); i++) {
			sklep.get(i).wyswietl();
		}

		System.out.println("------------------");

		Iterator<Ksiazka> iter = sklep.iterator();
		while (iter.hasNext()) {
			Ksiazka nextKsiazka = iter.next();
			nextKsiazka.wyswietl();
			// iter.next().wyswietl();
		}

		System.out.println("------------------");

		for (Iterator<Ksiazka> iter2 = sklep.iterator(); iter2.hasNext();) {
			Ksiazka ksiazka = iter2.next();
			ksiazka.wyswietl();
		}

		System.out.println("------------------");

		Iterator2 iter3 = new MyIter(sklep);
		while (iter3.jestWZakresie()) {
			Ksiazka k = iter3.elementBiezacy();
			k.wyswietl();
			iter3.nastepny();
		}
	}
}
