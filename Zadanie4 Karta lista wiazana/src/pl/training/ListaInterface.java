package pl.training;

public interface ListaInterface {

	public boolean Pusta(); // - zwraca true, jeœli lista jest pusta

	public void DodajPierwszy(Karta value); // -
											// wstawianie
											// nowego
											// elementu
											// na
											// pocz¹tek
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

	public void Usun(Karta value); // - usuniêcie elementu listy,

	public boolean Szukaj(Karta value); // - szukanie podanego elementu,

	public void Wyswietl(); // - wyœwietlanie listy,

	public int LiczbaElementow(); // - obliczanie liczby kart w liœcie,

	public void Kasuj(); // - usuwanie wszystkich elementów listy

}
