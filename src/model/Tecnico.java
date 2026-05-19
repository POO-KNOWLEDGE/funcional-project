package model;

public class Tecnico extends Persona {

    private String especialidad;

    public Tecnico(String nombre, String documento,
                    String telefono, String especialidad) {

        super(nombre, documento, telefono);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }
}
