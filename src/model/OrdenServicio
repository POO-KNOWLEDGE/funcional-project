package model;

public class OrdenServicio {

    private Cliente cliente;
    private Equipo equipo;
    private Tecnico tecnico;
    private String descripcionFalla;
    private double costo;

    public OrdenServicio(Cliente cliente,
                         Equipo equipo,
                         Tecnico tecnico,
                         String descripcionFalla,
                         double costo) {

        if (cliente == null) {
            throw new IllegalArgumentException("El cliente no puede ser nulo.");
        }
        if (equipo == null) {
            throw new IllegalArgumentException("El equipo no puede ser nulo.");
        }
        if (tecnico == null) {
            throw new IllegalArgumentException("El técnico no puede ser nulo.");
        }
        validateString(descripcionFalla, "Descripción de la falla");
        if (costo < 0) {
            throw new IllegalArgumentException("El costo no puede ser negativo.");
        }

        this.cliente = cliente;
        this.equipo = equipo;
        this.tecnico = tecnico;
        this.descripcionFalla = descripcionFalla;
        this.costo = costo;
    }

    private static void validateString(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El campo " + fieldName + " no puede estar vacío."
            );
        }
    }

    public void mostrarOrden() {

        System.out.println("\n===== ORDEN DE SERVICIO =====");

        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Equipo: " + equipo.getSerial());
        System.out.println("Técnico: " + tecnico.getNombre());
        System.out.println("Falla: " + descripcionFalla);
        System.out.println("Costo: $" + costo);

        equipo.mostrarInfo();
    }
}
