package model;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Average {

	private int count;
	private int sum;
	private Scanner scan;

	public Average() {
		scan = new Scanner(System.in);
		count = 0;
		sum = 0;
	}

	public void printWelcome() {
		System.out.println("Welcome to the Average application");
		System.out.println("The average and the sum of the values entered will be calculated");
	}

	public void printGoodBye() {
		System.out.println();
		if (count == 0)
			System.out.println("No values were entered.");
		else {
			double average = (double) sum / count;

			DecimalFormat fmt = new DecimalFormat("0.###");
			System.out.println("The average is " + fmt.format(average));
		}
	}

	// -----------------------------------------------------------------
	// Computes the average of a set of values entered by the user.
	// The running sum is printed as the numbers are entered.
	// -----------------------------------------------------------------
	public void start() {

		int value;

		boolean finished = false;

		printWelcome();
		
		while (!finished) {

			System.out.print("Enter an integer (0 to quit): ");
			value = scan.nextInt();
			if (value == 0) {
				finished = true;
			} else {
				count++;
				sum = sum + value;
				System.out.println("The sum so far is " + sum);
			}

		}

		printGoodBye();
	}
}
