package exceptions;

public class WrongFileFormat extends Exception {
    public WrongFileFormat() {
    }

    public WrongFileFormat(String message) {
        super(message);
    }
}
