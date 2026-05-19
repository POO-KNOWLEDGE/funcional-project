package model;

import interfaces.Reparacion;

public abstract class Equipo implements Reparacion {

    private String serial;
    private String marca;
    private String estado;

    public Equipo(String serial, String marca, String estado) {
        validateString(serial, "Serial");
        validateString(marca, "Marca");
        validateString(estado, "Estado");

        this.serial = serial;
        this.marca = marca;
        this.estado = estado;
    }

    private static void validateString(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El campo " + fieldName + " no puede estar vacío."
            );
        }
    }

    public String getSerial() {
        return serial;
    }

    public String getMarca() {
        return marca;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public abstract void mostrarInfo();
}
