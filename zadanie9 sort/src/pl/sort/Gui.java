package pl.sort;

import java.util.Arrays;
import java.util.Scanner;

import pl.sort.algorytmySortujace.BubbleSort;
import pl.sort.algorytmySortujace.HeapSort;
import pl.sort.algorytmySortujace.InsrtSort1;
import pl.sort.algorytmySortujace.InsrtSort2;
import pl.sort.algorytmySortujace.MergeSort;
import pl.sort.algorytmySortujace.QuickSort;
import pl.sort.algorytmySortujace.SelectSort;
import pl.sort.algorytmySortujace.ShellSort;
import pl.sort.tabliceZDanymi.Down;
import pl.sort.tabliceZDanymi.RandomList;
import pl.sort.tabliceZDanymi.Up;

public class Gui {

	ListUseAlgorithms addToTheList = new ListUseAlgorithms();

	public void start() {
		Scanner input = new Scanner(System.in);
		boolean continueExecution = true;

		while (continueExecution) {
			printMenu();
			String choice = input.nextLine();

			switch (choice) {
			case "1":
				choiceAlgorithms(input);
				continueExecution = false;
				break;
			case "2":
				addToTheList.display();
				break;
			case "3":
				System.out.println("Wybrales opcje wyjscie z programu");
				continueExecution = false;
			default:
				System.out.println("Nie poprawna opcja. Spróbuj ponownie ;)");
				// System.out.println("Wyszedles z programu");
				// continueExecution = false;
				break;
			}
		}
		input.close();
	}

	private void printMenu() {
		System.out.println();
		System.out.println("Sortowanie dla 5000 elementów");
		System.out.println("1.\tWybierz algorytm sortuj¹cy");
		System.out.println("2.\tPorównanie czasów urzytych algortytmów");
		System.out.println("3.\tWyjœcie z programu");
	}

	private void choiceAlgorithms(Scanner input) {
		listAlgorithms();
		String choiceAlgorithms = input.nextLine();

		Up up = new Up();
		Down down = new Down();
		RandomList random = new RandomList();

		Sort algoritm = getAlgoritm(choiceAlgorithms);

		if (algoritm != null) {
			testTimeOfAlgoritmExecusion(algoritm, up, down, random);
		} else {
			choiceAlgorithms(input);
		}
	}

	private Sort getAlgoritm(String choiceAlgorithms) {
		Sort algoritm = null;

		switch (choiceAlgorithms) {
		case "1":
			algoritm = new InsrtSort1();
			break;
		case "2":
			algoritm = new InsrtSort2();
			break;
		case "3":
			algoritm = new BubbleSort();
			break;
		case "4":
			algoritm = new SelectSort();
			break;
		case "5":
			algoritm = new ShellSort();
			break;
		case "6":
			algoritm = new QuickSort();
			break;
		case "7":
			algoritm = new HeapSort();
			break;
		case "8":
			algoritm = new MergeSort();
		case "9":
			start();
			break;
		default:
			System.out.println("Wybierz poprawnie algorytm cyframi od 1 do 8 lub wyjscie 9");
			break;
		}
		return algoritm;
	}

	private void testTimeOfAlgoritmExecusion(Sort algoritm, ListGenerator up, ListGenerator down, ListGenerator random) {
		long time1 = getTimeOfAlgoritmExecution(algoritm, up);
		long time2 = getTimeOfAlgoritmExecution(algoritm, down);
		long time3 = getTimeOfAlgoritmExecution(algoritm, random);

		addToTheList.add(new TimeAlgorithms(algoritm.getClass().getSimpleName(), time1, time2, time3));
		start();
	}

	private long getTimeOfAlgoritmExecution(Sort algoritm, ListGenerator generator) {
		System.out.println("Array " + generator.getClass().getSimpleName() + " " + algoritm.getClass().getSimpleName() + ":");
		long startTime = System.currentTimeMillis();
		System.out.println(Arrays.toString(algoritm.sort(generator.generator())));
		long stopTime = System.currentTimeMillis();
		long time = stopTime - startTime;
		System.out.println("Czas wykonania (w milisekundach) dla " + generator.getClass().getSimpleName() + ": " + (time));
		return time;
	}

	private void listAlgorithms() {
		System.out.println();
		System.out.println("1.\tInsert Sort 1");
		System.out.println("2.\tInsert Sort 2");
		System.out.println("3.\tBubble Sort");
		System.out.println("4.\tSelectSort");
		System.out.println("5.\tShellSort");
		System.out.println("6.\tQuickSort");
		System.out.println("7.\tHeapSort");
		System.out.println("8.\tMergeSort");
		System.out.println("9.\tPowrót do menu");

	}
}
