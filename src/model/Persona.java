package model;

public class Persona {

    private String nombre;
    private String documento;
    private String telefono;

    public Persona(String nombre, String documento, String telefono) {
        validateString(nombre, "Nombre");
        validateString(documento, "Documento");
        validateString(telefono, "Teléfono");

        this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;
    }

    private static void validateString(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El campo " + fieldName + " no puede estar vacío."
            );
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public String getTelefono() {
        return telefono;
    }
}
