package study;

// Custom checked exception class
public class WrongOperatorException extends Exception {
    public WrongOperatorException(String message) {
        super(message);
    }
}
