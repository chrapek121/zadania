package pl.training;

public interface ListaInterface {

	public boolean Pusta(); // - zwraca true, je�li lista jest pusta

	public void DodajPierwszy(Karta value); // -
											// wstawianie
											// nowego
											// elementu
											// na
											// pocz�tek
											// listy,

	public void UsunPierwszy(); // -
								// usuwanie
								// pierwszego
								// elementu
								// listy,

	public void Dodaj(Karta value); // -
									// wstawianie
									// nowego
									// elementu
									// do
									// listy,

	public void Usun(Karta value); // - usuni�cie elementu listy,

	public boolean Szukaj(Karta value); // - szukanie podanego elementu,

	public void Wyswietl(); // - wy�wietlanie listy,

	public int LiczbaElementow(); // - obliczanie liczby kart w li�cie,

	public void Kasuj(); // - usuwanie wszystkich element�w listy

}
