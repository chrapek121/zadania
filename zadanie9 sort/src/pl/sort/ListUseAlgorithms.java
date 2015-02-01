package pl.sort;

import java.util.ArrayList;
import java.util.List;

public class ListUseAlgorithms {

	List<TimeAlgorithms> listTimes = new ArrayList<TimeAlgorithms>();

	public void add(TimeAlgorithms timeAlgor) {

		listTimes.add(timeAlgor);
	}

	public int size() {

		return listTimes.size();
	}

	public void display() {

		for (int i = 0; i < listTimes.size(); i++) {
			System.out.println((i + 1) + ". " + listTimes.get(i));
		}
	}
}
