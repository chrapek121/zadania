package pl.sort;

public class TimeAlgorithms {

	public String nameAlgorithms;
	public long timeUp;
	public long timeDown;
	public long timeRandom;

	public TimeAlgorithms(String nameAlgorithms, long timeinsrtSort1_1, long timeinsrtSort1_2, long timeinsrtSort1_3) {
		this.nameAlgorithms = nameAlgorithms;
		this.timeUp = timeinsrtSort1_1;
		this.timeDown = timeinsrtSort1_2;
		this.timeRandom = timeinsrtSort1_3;
	}

	public String toString() {
		return String.format("%s | Czas dla wartoœci rosn¹cych  %d ms | Czas dla wartoœci malej¹cych %d ms | Czas dla wartoœci losowych %d ms",
				nameAlgorithms, timeUp, timeDown, timeRandom);
	}
}
