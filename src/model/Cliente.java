package model;

public class Cliente extends Persona {

    private String codigoCliente;

    public Cliente(String nombre, String documento,
                    String telefono, String codigoCliente) {

        super(nombre, documento, telefono);
        validateString(codigoCliente, "Código Cliente");
        this.codigoCliente = codigoCliente;
    }

    private static void validateString(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El campo " + fieldName + " no puede estar vacío."
            );
        }
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }
}
