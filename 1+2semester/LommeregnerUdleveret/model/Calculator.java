package model;

public class Calculator {
	//The current state of the calculator.
	private int state;
	
	//Operator buttons set state to OPR.
	private final int OPR = 0;
	
	//Digit buttons set state to NUM.
	private final int NUM = 1;
	
	//Last calculated number.
	private int num1;

	//Last entered operator.
	//Operators are: + - * / =.
	private char op1;

	//Number currently being entered.
	//if state == OPR, num2 is undefined.
	private int num2;

	public Calculator() {
		
	}

	// TODO getters
	
	public void addDigit(char digit) {
		String temp;
		if(state == OPR){
			
		}
		
	}

	public void enterOp(char op2) {
		// TODO
	}

}
