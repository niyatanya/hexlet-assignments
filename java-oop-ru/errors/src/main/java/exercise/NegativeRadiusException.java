package exercise;

// BEGIN
public class NegativeRadiusException extends Exception {
    String message;

    public NegativeRadiusException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
// END
