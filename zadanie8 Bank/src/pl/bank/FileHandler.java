package pl.bank;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileHandler {

	// Zapisuje dokładnie jeden obiekt do pliku

	public void save(DataBaseHandler dateBase) throws IOException {
		ObjectOutputStream dB = null;
		try {
			dB = new ObjectOutputStream(new FileOutputStream("bank.db"));
			dB.writeObject(dateBase);
			dB.flush();
		} finally {
			if (dB != null)
				dB.close();
		}
	}

	// Odczytuje dokładnie jeden obiekt z pliku i wyświetla o nim informację

	public DataBaseHandler read() throws IOException, ClassNotFoundException {
		ObjectInputStream dB = null;

		try {
			dB = new ObjectInputStream(new FileInputStream("Bank.db"));
			return (DataBaseHandler) dB.readObject();

		} catch (EOFException ex) {
			System.out.println("Koniec pliku");
		}

		finally {
			if (dB != null)
				dB.close();
		}
		return null;

	}

}
