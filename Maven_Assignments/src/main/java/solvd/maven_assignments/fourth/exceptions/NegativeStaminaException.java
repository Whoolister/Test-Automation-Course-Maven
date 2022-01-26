package exceptions;

public class NegativeStaminaException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public NegativeStaminaException(String message) {
        super(message);
    }
}
