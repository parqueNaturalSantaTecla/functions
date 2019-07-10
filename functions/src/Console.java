
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Console {

	private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public String readString(String title) {
		String input = null;
		boolean ok = false;
		do {
			this.write(title);
			try {
				input = this.bufferedReader.readLine();
				ok = true;
			} catch (Exception ex) {
				this.writeError("characte string");
			}
		} while (!ok);
		return input;
	}

	public int readInt(String title) {
		int input = 0;
		boolean ok = false;
		do {
			try {
				input = Integer.parseInt(this.readString(title));
				ok = true;
			} catch (Exception ex) {
				this.writeError("integer");
			}
		} while (!ok);
		return input;
	}
	
	public double readDouble(String title) {
		double input = 0;
		boolean ok = false;
		do {
			try {
				input = Double.parseDouble(this.readString(title));
				ok = true;
			} catch (Exception ex) {
				this.writeError("double");
			}
		} while (!ok);
		return input;
	}

	public char readChar(String title) {
		char charValue = ' ';
		boolean ok = false;
		do {
			String input = this.readString(title);
			if (input.length() != 1) {
				this.writeError("character");
			} else {
				charValue = input.charAt(0);
				ok = true;
			}
		} while (!ok);
		return charValue;
	}

	public void writeln() {
		System.out.println();
	}

	public void write(String value) {
		System.out.print(value);
	}

	public void writeln(String value) {
		this.write(value);
		this.writeln();
	}

	public void write(char value) {
		System.out.print(value);
	}
	
	public void writeln(char value) {
		this.write(value);
		this.writeln();
	}

	public void write(long value) {
		System.out.print(value);
	}
	
	public void writeln(long value) {
		this.write(value);
		this.writeln();
	}
	
	public void write(double value) {
		System.out.print(value);
	}
	
	public void writeln(double value) {
		this.write(value);
		this.writeln();
	}
	
	public void write(boolean value) {
		System.out.print(value);
	}
	
	public void writeln(boolean value) {
		this.write(value);
		this.writeln();
	}

	private void writeError(String format) {
		System.out.println("FORMAT ERROR! " + "Enter a " + format + " formatted value.");
	}
}
