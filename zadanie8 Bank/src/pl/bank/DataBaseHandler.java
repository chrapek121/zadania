package pl.bank;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataBaseHandler implements Serializable {

	private static final long serialVersionUID = 1191259248390554034L;

	List<Client> dataBase;

	public DataBaseHandler() {
		dataBase = new ArrayList<Client>();
	}

	public void add(Client client) {

		dataBase.add(client);
	}

	public void remove(int numberClient) {

		dataBase.remove(numberClient);
	}

	public int size() {

		return dataBase.size();
	}

	public void display() {

		for (int i = 0; i < dataBase.size(); i++) {
			System.out.println((i) + ". " + dataBase.get(i));
		}
	}

	public void displayOneList() {
		for (int i = 0; i < dataBase.size(); i++) {
			System.out.println((i) + ". " + dataBase.get(i).displaySurnameAndName());
		}

	}

	public void displayOne(Integer choice) {
		if (choice < dataBase.size()) {
			System.out.println(dataBase.get(choice).toString());
		} else {
			System.out.println("Brak klienta w bazie. Sprobuj jeszcze raz");
		}
	}

	public boolean empty() {
		return dataBase.isEmpty();
	}

	public void setName(int nrClinet, String newName) {
		dataBase.get(nrClinet).name = newName;
	}

	public void setSurname(int nrClinet, String newSurname) {
		dataBase.get(nrClinet).surname = newSurname;
	}

	public void setPesel(int nrClinet, Long newPesel) {
		dataBase.get(nrClinet).pesel = newPesel;
	}

	public void setNumberAccount(int nrClinet, int newNumberAccount) {
		dataBase.get(nrClinet).numberAccount = newNumberAccount;
	}

	public void setPayments(int nrClinet, double newPayments) {
		dataBase.get(nrClinet).payments = newPayments;
	}

	public void setDate(int nrClinet, Date newDate) {
		dataBase.get(nrClinet).dateOfPament = newDate;
	}

	public void setInterest(int nrClinet, double newInterest) {
		dataBase.get(nrClinet).interest = newInterest;
	}

	public void setType(int nrClinet, Investment newType) {
		dataBase.get(nrClinet).type = newType;
	}

}
