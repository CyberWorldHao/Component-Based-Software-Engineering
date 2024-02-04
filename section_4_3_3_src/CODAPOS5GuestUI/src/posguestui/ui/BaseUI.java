package posguestui.ui;

import java.text.DecimalFormat;
import java.util.Scanner;

public abstract class BaseUI {

	private static Scanner scanner = new Scanner(System.in);

	/**
	 * Calls the doDisplayUI() method time and again until it returns false To be
	 * called from client classes on concrete UI classes
	 */
	public void displayUI() {
		boolean continueDisplay = false;

		do {
			continueDisplay = doDisplayUI();
		} while (continueDisplay);

	}

	/**
	 * To be overridden by concrete UI classes
	 * 
	 * @return - Boolean to indicate whether to continue display one more time
	 */
	protected boolean doDisplayUI() {
		return false;
	}

	/**
	 * Utility method to format a String by padding right with spaces
	 * 
	 * @param string
	 *            - Input String to be formatted
	 * @param size
	 *            - Total size of the output String including the padding
	 * @return - Formatted String of length size
	 */
	public String padRight(String string, int size) {

		if (size < string.length())
			return string.substring(0, size);

		StringBuilder builder = new StringBuilder(string);
		for (int i = 0; i < (size - string.length()); i++) {
			builder.append(' ');
		}

		return builder.toString();
	}
	
	
	/**
	 * Displays the error message to the user
	 * @param errString - error message to be displayed
	 */
	public void displayError(String errString) {
		System.out.println("\n***** ERROR - " + errString + " *****\n");
	}

	/**
	 * Utility method to format a String by padding left with spaces
	 * 
	 * @param string
	 *            - Input String to be formatted
	 * @param size
	 *            - Total size of the output String including the padding
	 * @return - Formatted String of length size
	 */
	public String padLeft(String string, int size) {

		if (size < string.length())
			return string.substring(0, size);

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < (size - string.length()); i++) {
			builder.append(' ');
		}

		builder.append(string);
		return builder.toString();
	}

	/**
	 * Utility method to format a String by padding left and right with spaces
	 * 
	 * @param string
	 *            - Input String to be formatted
	 * @param size
	 *            - Total size of the output String including the padding
	 * @return - Formatted String of length size
	 */
	public String center(String string, int size) {

		if (size < string.length())
			return string.substring(0, size);

		int leftPadding = (size - string.length()) / 2;

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i <= leftPadding; i++) {
			builder.append(' ');
		}

		builder.append(string);

		for (int i = 0; i < (size - string.length() - leftPadding); i++) {
			builder.append(' ');
		}

		return builder.toString();

	}

	/**
	 * Utility method to format input decimal number to two fraction digits,
	 * right aligned
	 * 
	 * @param number
	 *            - Input number to be formatted
	 * @param size
	 *            - Field size to which the number should be right aligned
	 * @return - String representation of number of width size, right aligned
	 *         with two decimal digits
	 */
	public String formatNumber(double number, int size) {
		DecimalFormat decimalFormat = (DecimalFormat) DecimalFormat
				.getInstance();
		decimalFormat.setMaximumFractionDigits(2);
		decimalFormat.setMinimumFractionDigits(2);
		return padLeft(decimalFormat.format(number), size);
	}

	/**
	 * Scans a console line and gets an integer input
	 * 
	 * @return - integer value if input was number, 0 otherwise
	 */
	protected int scanInt() {
		int output = 0;
		String inputString = scanner.nextLine();

		if (inputString.length() > 0) {
			try {
				output = Integer.parseInt(inputString);
			} catch (NumberFormatException e) {
			}
		}

		return output;
	}

	/**
	 * Scans a console line and gets an integer input
	 * 
	 * @return - Integer if the input was integer, null otherwise
	 */
	protected Integer scanInteger() {
		Integer output = null;
		String inputString = scanner.nextLine();

		if (inputString.length() > 0) {
			try {
				output = Integer.parseInt(inputString);
			} catch (NumberFormatException e) {
				return null;
			}
		}

		return output;
	}

	/**
	 * Scans a console line and gets a double input
	 * 
	 * @return - Double if the input was number, null otherwise
	 */
	protected Double scanDouble() {
		Double output = null;
		String inputString = scanner.nextLine();

		if (inputString.length() > 0) {
			try {
				output = Double.parseDouble(inputString);
			} catch (NumberFormatException e) {
				return null;
			}
		}

		return output;
	}

	/**
	 * Scans a console line and gets a String input
	 * 
	 * @return - String if any input was given, null if none (on pressing Enter)
	 */
	protected String scanString() {

		String inputString = scanner.nextLine();

		if (inputString.length() > 0) {
			return inputString;
		}

		return null;
	}

	/**
	 * Scans the console for Y or N
	 * @return - true if Y/y is pressed, false otherwise
	 */
	protected boolean scanYesNo() {
		String yesNo = scanString();
		if (yesNo != null && (yesNo.startsWith("Y") || yesNo.startsWith("y")))
			return true;
		return false;
	}

}
