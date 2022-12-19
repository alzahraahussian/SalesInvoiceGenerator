package exceptions;

public class FileNotFound extends  Exception{
    public FileNotFound() {
    }

    public FileNotFound(String message) {
        super(message);
    }
}
