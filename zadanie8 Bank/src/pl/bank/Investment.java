package pl.bank;

public enum Investment {

	A_VISTA(0), MONTH_1(30), MONTH_3(90), MONTH_6(180), YEAR_1(365);

	private int type;

	private Investment(int type) {
		this.type = type;
	}

	public int getType() {

		return type;
	}
}
