package pl.bank;

import java.io.Serializable;
import java.util.Date;

public class Client implements Serializable {

	/***/
	private static final long serialVersionUID = 6248367622369796747L;
	public String surname;
	public String name;
	public long pesel;
	public int numberAccount;
	// wp³aty
	public double payments;
	public Date dateOfPament;
	// odsetki
	public double interest;
	public Investment type;
	// saldo
	public double balance;

	public Client(String surname, String name, long pesel, int numberAccount, double payments, Date dateOfPament, double interest, Investment type,
			double balance) {
		this.surname = surname;
		this.name = name;
		this.pesel = pesel;
		this.numberAccount = numberAccount;
		this.payments = payments;
		this.dateOfPament = dateOfPament;
		this.interest = interest;
		this.type = type;
		this.balance = balance;

	}

	public String toString() {
		return String.format("%s %s %d %d %f %s %f %s %f", surname, name, pesel, numberAccount, payments, dateOfPament, interest, type, balance);
	}

	public String displaySurnameAndName() {
		return String.format("%s %s ", surname, name);
	}
}