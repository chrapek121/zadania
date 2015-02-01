package wybory_zygol;

/**
 * 
 * Author: Zygmunt Horodyski
 * 
 */

public class Kolejka {
	Wezel first;
	Wezel temp;
	private int size = 0;

	// czy stos jest pusty
	public boolean isEmpty() {
		return first == null;
	}

	// d³ugoœæ kolejki
	public int size() {
		return size;
	}

	// dodaje element do kolejki
	public void add(Object item) {
		Wezel element = first;
		Wezel wstawiany = new Wezel(item, size + 1);

		if (first == null) {
			first = wstawiany;
			first.next = first;
			first.previous = first;
		} else {
			while (element.numer != size)
				element = element.next;
			wstawiany.next = first;
			wstawiany.previous = element;
			element.next = wstawiany;
		}
		size++;
	}

	// usówa i zwraca pierwszy element kolejki
	public Object remove() {
		temp.next.previous = temp.previous;
		temp.previous.next = temp.next;
		size--;
		return temp.item;
	}
}
