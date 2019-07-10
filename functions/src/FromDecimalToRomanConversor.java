class FromDecimalToRomanConversor extends Console {

	public static void main(String[] args) {
		new FromDecimalToRomanConversor().exec();
	}

	// TODO
	private void exec() {
		for (int i = 0; i < 1000; i++) {
			writeln("Número romano " + i + ": " + fromDecimalToRomanNumberTranslate(i) + ".");
		}
	}

	final int MAXIMUM_DECIMAL = 4000;

	String fromDecimalToRomanNumberTranslate(int decimalNumber) {
		assert decimalNumber < MAXIMUM_DECIMAL;
		String romanNumber = "";
		for (int i = 3; i >= 0; i--) {
			int decimalDigit = decimalNumber / power(10, i) % 10;
			romanNumber += fromDecimalToRomanDigitTranslate(decimalDigit, i);
		}
		return romanNumber;
	}

	int power(int base, int exponent) {
		assert exponent >= 0;
		int power = 1;
		for (int i = 0; i < exponent; i++) {
			power *= base;
		}
		return power;
	}

	String fromDecimalToRomanDigitTranslate(int decimalDigit, int position) {
		assert 0 <= decimalDigit && decimalDigit < 2 * GROUP_VALUE;
		assert 0 <= position && position < amountDigits(MAXIMUM_DECIMAL);
		String romanDigit = "";
		romanDigit += negativeUnitsPart(decimalDigit, position);
		romanDigit += groupPart(decimalDigit, position);
		romanDigit += positiveUnitsPart(decimalDigit, position);
		return romanDigit;
	}

	final int UNIT_VALUE = 1;
	final int GROUP_VALUE = 5;
	final String[] UNIT_CHARACTERS = { "I", "X", "C", "M" };
	final String[] GROUP_CHARACTERS = { "V", "L", "D" };
	final int MAXIMUN_REPETITION = 3;

	String negativeUnitsPart(int decimalDigit, int position) {
		assert 0 <= decimalDigit && decimalDigit < 2 * GROUP_VALUE;
		assert 0 <= position && position < amountDigits(MAXIMUM_DECIMAL);
		if (decimalDigit == GROUP_VALUE - UNIT_VALUE || decimalDigit == 2 * GROUP_VALUE - UNIT_VALUE) {
			return UNIT_CHARACTERS[position];
		}
		return " ";
	}

	int amountDigits(int number) {
		assert number > 0;
		int amountDigits = 0;
		while (number > 0) {
			amountDigits++;
			number /= 10;
		}
		if (amountDigits == 0) {
			amountDigits++;
		}
		return amountDigits;
	}

	String groupPart(int decimalDigit, int position) {
		assert 0 <= decimalDigit && decimalDigit < 2 * GROUP_VALUE;
		assert 0 <= position && position < amountDigits(MAXIMUM_DECIMAL);
		if (GROUP_VALUE - UNIT_VALUE <= decimalDigit && decimalDigit < 2 * GROUP_VALUE - UNIT_VALUE) {
			return GROUP_CHARACTERS[position];
		}
		if (decimalDigit == 2 * GROUP_VALUE - UNIT_VALUE) {
			return UNIT_CHARACTERS[position + 1];
		}
		return " ";
	}

	String positiveUnitsPart(int decimalDigit, int position) {
		assert 0 <= decimalDigit && decimalDigit < 2 * GROUP_VALUE;
		assert 0 <= position && position < amountDigits(MAXIMUM_DECIMAL);
		if (decimalDigit % GROUP_VALUE <= MAXIMUN_REPETITION) {
			String positiveUnitPart = "";
			for (int i = 0; i < decimalDigit % GROUP_VALUE; i++) {
				positiveUnitPart += UNIT_CHARACTERS[position];
			}
			for (int i = 0; i < MAXIMUN_REPETITION - decimalDigit % GROUP_VALUE; i++) {
				positiveUnitPart += " ";
			}
			return positiveUnitPart;
		}
		return "   ";
	}

}
