package study;

public class Calculator {

    // Static method to perform calculation
    public static int calculate(int number1, int number2, String operator) throws WrongOperatorException {
        switch (operator) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "/":
                if (number2 == 0) {
                    throw new ArithmeticException("Division by zero is not allowed");
                }
                return number1 / number2;
            case "%":
                return number1 % number2;
            default:
                // Throw custom checked exception for invalid operator
                throw new WrongOperatorException("Invalid operator: " + operator);
        }
    }
}
