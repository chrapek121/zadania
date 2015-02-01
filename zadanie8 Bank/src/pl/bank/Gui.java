package pl.bank;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Gui {
	DataBaseHandler dataBase;
	FileHandler fileHandler = new FileHandler();
	Date todayDate = new Date();

	public void run() throws IOException, ClassNotFoundException, ParseException {
		Scanner input = new Scanner(System.in);
		boolean continueExecution = true;

		while (continueExecution) {
			printMenu();
			String choice = input.nextLine();

			switch (choice) {
			case "1":
				createNewDataBase();
				break;
			case "2":
				readingDataBaseFile();
				break;
			case "3":
				displayAllRecords();
				break;
			case "4":
				displayDataOneClient(input);
				break;
			case "5":
				addNewClient(input);
				break;
			case "6":
				removeClient(input);
				break;
			case "7":
				updateDateClient(input);
				break;
			case "8":
				saveDataBaseFile();
				break;
			case "9":
				System.out.println("Wybrales opcje wyjscie z programu");
				continueExecution = false;
			default:
				System.out.println("Wyszedles z programu");
				break;
			}
		}
		input.close();
	}

	private void printMenu() {
		System.out.println();
		System.out.println("1.\tUtworzenie nowej bazy danych");
		System.out.println("2.\tOdczyt bazy z pliku");
		System.out.println("3.\tWyœwietlenie wszystkich rekordów");
		System.out.println("4.\tWyœwietlenie danych jednego klienta");
		System.out.println("5.\tDopisanie nowego klienta");
		System.out.println("6.\tUsuniêcie klienta z bazy");
		System.out.println("7.\tAktualizowanie danych klienta");
		System.out.println("8.\tZapis bazy do pliku");
		System.out.println("9.\tWyjscie z programu");

	}

	private void createNewDataBase() throws FileNotFoundException {
		dataBase = new DataBaseHandler();
		System.out.println("Nowa baza danych zostala utworzona");
	}

	private void readingDataBaseFile() throws ClassNotFoundException, IOException {
		File file = new File("bank.db");
		if (file.exists()) {
			dataBase = fileHandler.read();
			System.out.println("Odczytano baze danych");
		} else {
			System.out.println("Baza danych nie istnieje");
		}
	}

	private void displayAllRecords() {
		if (dataBase != null && !dataBase.empty()) {
			dataBase.display();
		} else {
			System.out.println("Baza danych jest pusta");
		}
	}

	private void displayDataOneClient(Scanner input) {
		if (dataBase != null && !dataBase.empty()) {
			dataBase.displayOneList();
			Integer choice = -1;
			while (choice == -1) {
				System.out.println("Podaj nr klienta z listy powy¿ej");
				String choicee = input.nextLine();
				try {
					choice = Integer.valueOf(choicee);
				} catch (NumberFormatException e) {
					System.out.println("Podaj poprawnie numer klienta");
				}
			}
			dataBase.displayOne(choice);
		} else {
			System.out.println("Baza danych jest pusta");
		}
	}

	private void addNewClient(Scanner input) throws ParseException {

		if (dataBase != null) {
			String name = setName(input);
			String surname = setSurname(input);
			long pesel = setPesel(input);
			Integer numberAccount = setNumberAccount(input);
			double payments = setPayments(input);
			Date date = setDate(input);
			double interest = setInterest(input);
			Investment type = setType(input);
			double balance = setBalance(date, type, interest, payments);

			Client client = new Client(name, surname, pesel, numberAccount, payments, date, interest, type, balance);
			dataBase.add(client);
			System.out.println("Dodano nowego klienta");
		} else {
			System.out.println("Aby dodac klienta musisz utworzyæ b¹dz odczytac baze");
		}
	}

	public Investment setType(Scanner input) {
		Investment type = null;
		while (type == null) {
			System.out.println("Podaj lokate: A_VISTA, MONTH_1,  MONTH_3, MONTH_6, YEAR_1");
			String typee = input.nextLine();
			try {
				type = Investment.valueOf(typee);
			} catch (IllegalArgumentException e) {
				System.out.println("Wpisz poprawnie rodzaj lokaty");

			}
		}
		return type;
	}

	public double setInterest(Scanner input) {
		double balance = -1;
		while (balance == -1) {
			System.out.println("Odsetki w formacie x.xx");
			String balancee = input.nextLine();
			try {
				balance = Double.parseDouble(balancee);
			} catch (NumberFormatException e) {
				System.out.println("Odsetki musza byc liczba");
			}
		}
		return balance;
	}

	public Date setDate(Scanner input) {
		Date date = null;
		while (date == null) {
			System.out.println("Podaj date w formacie yyyy-MM-dd");
			String datee = input.nextLine();
			DateFormat form = new SimpleDateFormat("yyyy-MM-dd");
			form.setLenient(false);
			try {
				date = form.parse(datee);
				String format = form.format(todayDate);
				if (date.compareTo(form.parse(format)) > 0) {
					date = null;
					System.out.println("Data nie moze wybiegac w przysz³osc");
				}

			} catch (ParseException e) {
				System.out.println("Podaj prawidlowy format daty");
			}
		}
		return date;
	}

	public double setPayments(Scanner input) {
		double balance = -1;
		while (balance == -1) {
			System.out.println("Sume wp³at w formacie x.xx");
			String balancee = input.nextLine();
			try {
				balance = Double.parseDouble(balancee);
			} catch (NumberFormatException e) {
				System.out.println("Suma wp³at musi byc liczba");
			}
		}
		return balance;
	}

	public Integer setNumberAccount(Scanner input) {
		Integer numberAccount = -1;
		while (numberAccount == -1) {
			System.out.println("Podaj numer konta");
			String numberAccountt = input.nextLine();
			try {
				numberAccount = Integer.valueOf(numberAccountt);
			} catch (NumberFormatException e) {
				System.out.println("Numer konta musi byc liczba");
			}
		}
		return numberAccount;
	}

	public long setPesel(Scanner input) {
		long pesel = -1;
		while (pesel == -1) {
			System.out.println("Podaj pesel (11 znaków)");
			String pesell = input.nextLine();
			if (pesell.length() == 11) {
				try {
					pesel = Long.parseLong(pesell);

				} catch (NumberFormatException e) {
					System.out.println("Pesel musi byc liczba");
				}
			} else {
				System.out.println("Pesel musi posiadaæ odpowiedznia iloœæ znaków");
			}
		}
		return pesel;
	}

	public String setSurname(Scanner input) {
		System.out.println("Podaj nazwisko");
		String surname = input.nextLine();
		return surname;
	}

	public String setName(Scanner input) {
		System.out.println("Podaj imie");
		String name = input.nextLine();
		return name;
	}

	private void removeClient(Scanner input) {
		if (dataBase != null && !dataBase.empty()) {
			dataBase.displayOneList();
			Integer choice = -1;
			while (choice == -1) {
				System.out.println("Podaj nr klienta z listy powy¿ej, ktorego chcesz usunac z bazy danych");
				String choicee = input.nextLine();
				try {
					choice = Integer.valueOf(choicee);
				} catch (NumberFormatException e) {
					System.out.println("Podaj poprawnie numer klienta");
				}
			}
			if (choice <= dataBase.size()) {
				dataBase.remove(choice);
				System.out.println("Usunieto wybranego klienta");
			} else {
				System.out.println("Brak klienta o tym numerze w bazie danych");
			}
		} else {
			System.out.println("Baza danych jest pusta");
		}
	}

	private void updateDateClient(Scanner input) {
		if (dataBase != null && !dataBase.empty()) {
			dataBase.displayOneList();
			Integer choice = -1;
			while (choice == -1) {
				System.out.println("Podaj nr klienta do aktualizacji danych z listy powy¿ej");
				String choicee = input.nextLine();
				try {
					choice = Integer.valueOf(choicee);
				} catch (NumberFormatException e) {
					System.out.println("Podaj poprawnie numer klienta");
				}
			}
			System.out.println("Aktualne dane klienta");
			dataBase.displayOne(choice);
			System.out.println("Wybierz jakie dane klienta chcesz zaktualizowac:\n0. Imie \n1. "
					+ "Nazwisko \n2. Pesel \n3. Numer konta\n4. Wp³aty \n5. Data \n6. Odsetki \n7. Lokata");
			String choiceUpdate = input.nextLine();
			switch (choiceUpdate) {
			case "0":
				dataBase.setName(choice, setName(input));
				break;
			case "1":
				dataBase.setSurname(choice, setSurname(input));
				break;
			case "2":
				dataBase.setPesel(choice, setPesel(input));
				break;
			case "3":
				dataBase.setNumberAccount(choice, setNumberAccount(input));
				break;
			case "4":
				dataBase.setPayments(choice, setPayments(input));
				break;
			case "5":
				dataBase.setDate(choice, setDate(input));
				break;
			case "6":
				dataBase.setType(choice, setType(input));
				break;
			}
			System.out.println("Dane wybranego klienta zosta³y zaktualizowane");
		} else {
			System.out.println("Baza danych jest pusta");
		}
	}

	private void saveDataBaseFile() throws IOException {
		if (dataBase != null) {
			fileHandler.save(dataBase);
			System.out.println("Zapisano baze danych");
		} else {
			System.out.println("Baza danych nie istnieje");
		}

	}

	private double setBalance(Date date, Investment type, double interest, double payments) {
		int difInDays = (int) ((todayDate.getTime() - date.getTime()) / (1000 * 60 * 60 * 24));

		return 0;
	}

}