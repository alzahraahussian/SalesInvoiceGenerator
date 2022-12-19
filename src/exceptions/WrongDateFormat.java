package exceptions;

public class WrongDateFormat  extends Exception{
    public WrongDateFormat() {
    }

    public WrongDateFormat(String message) {
        super(message);
    }
}
