package exceptions;

public class InvalidPaymentEntryException extends Exception {
    public InvalidPaymentEntryException(String message) {
        super(message);
    }
}
