import java.util.Scanner;

import study.Calculator;
import study.WrongOperatorException;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);

        try {
            // Taking user input
            System.out.print("Enter first number: ");
            int num1 = sc.nextInt();

            System.out.print("Enter second number: ");
            int num2 = sc.nextInt();

            System.out.print("Enter operator (+, -, *, /, %): ");
            String op = sc.next();

            // Perform calculation using Calculator class
            int result = Calculator.calculate(num1, num2, op);
            System.out.println("Result: " + result);
        } 
        catch (WrongOperatorException e) {
            System.out.println("Error: " + e.getMessage());
        }
        catch (ArithmeticException e) {
            System.out.println("Math Error: " + e.getMessage());
        }
        finally {
            sc.close();
        }
    

	}

}
