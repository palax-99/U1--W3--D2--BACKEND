package AntoninoPalazzolo.exceptions;

public class provaException extends RuntimeException {
    public provaException(long id) {
        super("L' evento con id " + id + "non'è stato trovato");
    }
}
