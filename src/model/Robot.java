package model;

public class Robot extends Equipo {

    private int cantidadSensores;

    public Robot(String serial, String marca, String estado, int cantidadSensores) {
        super(serial, marca, estado);
        this.cantidadSensores = cantidadSensores;
    }

    @Override
    public void reparar() {
        setEstado("Reparado");
        System.out.println("Robot reparado correctamente.");
    }

    @Override
    public void mostrarInfo() {
        System.out.println("ROBOT");
        System.out.println("Serial: " + getSerial());
        System.out.println("Marca: " + getMarca());
        System.out.println("Estado: " + getEstado());
        System.out.println("Sensores: " + cantidadSensores);
    }
}
