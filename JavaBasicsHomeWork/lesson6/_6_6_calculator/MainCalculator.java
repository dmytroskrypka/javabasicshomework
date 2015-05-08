package _6_6_calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Dmytro Skrypka
 *
 */
public class MainCalculator {
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("Input expression to calculate");
        BufferedReader d = new BufferedReader(new InputStreamReader(System.in));
        String s = d.readLine();
        
		try {
			System.out.println(myCalculator(0,"+",s));
		} catch (NotValidMathOperationException e) {
			System.out.println(e.getMessage());
		}

	}
	
/*
 * Performs math operation on given number 'a' and string 'remaining' 
 * If 'remaining' is not a number then parses first number from 'remaining' and perform operation on it
 * then defines next operator in remaining part of 'remaining' and recursively executes on it
 * @throws NotValidMathOperationException if operator is not valid math operator or no numbers are found
 * 
 * @param a first argument for math operation
 * 
 * @param operator the string that is supposed to be a math operator symbol
 * 
 * @param remaining string that is supposed to me a math expression 
 */
public static int myCalculator (int a, String operator, String remaining) throws NotValidMathOperationException {
	int b = 0;
	try {
		b = Integer.parseInt(remaining);
		return operation(a, b, operator);
	}catch (NumberFormatException e) {
		String fn = firstNumber(remaining);
		String fo = findOperator(remaining, fn.length());
		
		return myCalculator(myCalculator(a, operator, fn),
					fo, 
					remaining.substring(fo.length()+fn.length()));
	} 
}


/*
 * Performs math operation on given numbers a and b 
 * operator should be one of valid math operators: +, -, *, /
 * @throws NotValidMathOperationException if operator is not valid math operator
 * 
 * @param a first argument
 * 
 * @param b second argument
 * 
 * @param operator the string that is supposed to be a math operator symbol
 */	
public static int operation(int a, int b, String operator) throws NotValidMathOperationException	{
	switch (operator) {
		case "+":
			return a+b;
		case "-":
			return a-b;
		case "*":
			return a*b;
		case "/":
		try {
			return a/b;
		} catch (ArithmeticException e) {
			throw new NotValidMathOperationException("Expression contains division by zero");
		} 
		default :
			throw new NotValidMathOperationException("Expression doesn't contain valid math operations");	
	}
}

/*
 * Checks if given string expression starts with valid number and returns this number as string
 * @throws NotValidMathOperationException if first chars in the string are not numbers
 * 
 * @param s the string that is supposed to be a math expression
 */
public static String firstNumber(String s) throws NotValidMathOperationException{
	String subS = "";
	int i= 0;
	while (i < s.length() && Character.isDigit(s.charAt(i))){
		subS = subS + s.charAt(i);
		i++;
	}
	if(subS == ""){
		throw new NotValidMathOperationException("Expression must contain valid numbers");
	}
	return subS;
}

/*
 * Checks if given char is one of 4 valid math operators: +, -, *, /
 */
public static boolean isOperator(String s)  {
	return ("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s));
}

/*
 * Checks the string s for the valid math operator +, -, *, / at given position
 * @throws NotValidMathOperationException if there is no valid math operators at given position
 * 
 * @param s the string that is supposed to be a math expression
 * 
 * @param position char position in the string that needs to be checked for being math operation symbol
 * 
 */
public static String findOperator(String s, int position) throws NotValidMathOperationException{
	
	String operator = ""+s.charAt(position);

	if(!isOperator(operator)){
		throw new NotValidMathOperationException("Expression must contain valid math operations");
	} else return operator;
}

}
