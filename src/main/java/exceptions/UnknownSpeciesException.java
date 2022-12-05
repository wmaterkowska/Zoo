package exceptions;

public class UnknownSpeciesException extends Exception{
    public UnknownSpeciesException(String errorMessage) {
        super(errorMessage);
    }
}
