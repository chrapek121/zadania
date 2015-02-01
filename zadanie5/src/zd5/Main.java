package zd5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {

		// 1
		String ciagZnakow = "abc";

		// 2
		int n = ciagZnakow.length();

		// 3
		Stack<String> tunel = new Stack<String>();

		for (int i = 0; i < n; i++) {
			String jedenNaStos = ciagZnakow.substring(i, i + 1);
			tunel.push(jedenNaStos);
		}

		// 4
		System.out.println("Stos: " + tunel);

		// 5
		Queue<String> kolejka = new LinkedList<String>();
		for (int i = 0; i < n / 2; i++) {
			kolejka.add(tunel.pop());

		}

		if (n % 2 == 1) {
			tunel.pop();
		}
		// 6
		System.out.println("Kolejka" + kolejka);

		// 7
		Stack<String> tunel2 = new Stack<String>();
		for (int i = 0; i < n / 2; i++) {
			tunel2.push(kolejka.remove());
		}
		// 8
		System.out.println("Stos1: " + tunel);
		System.out.println("Stos2: " + tunel2);
		// 9
		if (tunel.toString().equals(tunel2.toString())) {
			System.out.println("Podany ciag jest palindromem");
		} else {
			System.out.println("Podany ciag nie jest palindromem ");
		}

		tunel.clear();
		tunel2.clear();
		System.out.println("Stos1 po czyczszeniu: " + tunel);
		System.out.println("Stos2 po czyczszeniu: " + tunel2);

	}
}
