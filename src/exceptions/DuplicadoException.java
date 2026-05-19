package exceptions;

public class DuplicadoException extends IllegalArgumentException {

    public DuplicadoException(String mensaje) {
        super(mensaje);
    }
}
