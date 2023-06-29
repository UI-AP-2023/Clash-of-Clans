package exception;

public class InvalidID extends InvalidInput{
    public InvalidID() {
        super("InvalidID");
    }

    public InvalidID(String message) {
        super(message);
    }
}
