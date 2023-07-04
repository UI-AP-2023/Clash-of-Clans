package exception;

public class DuplicatePlayerID extends DuplicateEntry {
    public DuplicatePlayerID(String message) {
        super(message);
    }

    public DuplicatePlayerID() {
        super("DuplicateUsername");
    }
}
