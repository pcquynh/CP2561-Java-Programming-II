package Assignment2;

/**
 * Specialized version of Exception: Invalid Account Exception
 * Assignment 2
 * CP2561 Winter 2022
 * @author Quynh
 */

/**
 *InvalidAccountException class extends Exception
 * It contains a private static final string called MSG that says
 * “The Chequing Account object is not valid!”
 */
public class InvalidAccountException extends Exception {
    private static final String MSG = "The Chequing Account object is not valid!";

    /**
     * Constructor that builds a new exception. It uses the default MSG from above
     */
    public InvalidAccountException() {
        super(MSG);
    }

    /**
     * Constructor that builds a new exception with the specified detail message
     * @param message the specified detail message
     */
    public InvalidAccountException(String message) {
        super(message);
    }

    /**
     * Constructor that builds a new exception with the specified detail message and cause
     * @param message the specified detail message
     * @param cause the cause
     */
    public InvalidAccountException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor that builds a new exception with the specified detail cause
     * It uses the default MSG from above
     * @param cause the cause
     */
    public InvalidAccountException(Throwable cause) {
        super(MSG);
    }
}
