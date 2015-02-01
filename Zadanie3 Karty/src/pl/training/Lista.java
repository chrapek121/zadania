package pl.training;

public interface Lista {

	public void insert(int i, Karta value) throws IndexOutOfBoundsException;

	public void add(Karta value);

	public Karta delete(int i) throws IndexOutOfBoundsException;

	public boolean delete(Karta value);

	public void clear();

	public Karta set(int i, Karta value) throws IndexOutOfBoundsException;

	public Karta get(int i) throws IndexOutOfBoundsException;

	public int indexOf(Karta value);

	public boolean contains(Karta value);

	public int size();

	public boolean isEmpty();

}
