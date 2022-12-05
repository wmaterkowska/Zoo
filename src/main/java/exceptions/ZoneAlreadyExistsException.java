package exceptions;

public class ZoneAlreadyExistsException extends Exception {

    public ZoneAlreadyExistsException(String errorMessage) {
        super(errorMessage);
    }
}
