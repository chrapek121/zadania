package wybory_zygol;

import java.io.IOException;

public class Main {

	public void praca(String s) throws IOException {
		Sejm sj = new Sejm(s);
		sj.symulacja();
	}

	public static void main(String[] args) throws IOException {
		Main mm = new Main();
		mm.praca("WB2.txt");
		// mm.praca("DA2");
		// mm.praca("DA3");
		// mm.praca("DA4");
		// mm.praca("DA5");
		// mm.praca("DA6");
	}
}
