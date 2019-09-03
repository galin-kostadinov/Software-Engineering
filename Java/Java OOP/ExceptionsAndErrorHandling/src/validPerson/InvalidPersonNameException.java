package validPerson;

public class InvalidPersonNameException extends RuntimeException {
    public InvalidPersonNameException() {
    }

    public InvalidPersonNameException(String message) {
        super(message);
    }
}
