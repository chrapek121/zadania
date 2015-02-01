package wybory_zygol;


public class Wezel {
	Object item;
	Wezel next;
	Wezel previous;
	int numer;
	boolean rzad = false;

	Wezel(Object item, int n) {
		this.item = item;
		numer = n;
	}
}