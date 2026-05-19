package model;

public class Dron extends Equipo {

    private double alturaMaxima;

    public Dron(String serial, String marca, String estado, double alturaMaxima) {
        super(serial, marca, estado);
        this.alturaMaxima = alturaMaxima;
    }

    @Override
    public void reparar() {
        setEstado("Reparado");
        System.out.println("Dron reparado correctamente.");
    }

    @Override
    public void mostrarInfo() {
        System.out.println("DRON");
        System.out.println("Serial: " + getSerial());
        System.out.println("Marca: " + getMarca());
        System.out.println("Estado: " + getEstado());
        System.out.println("Altura máxima: " + alturaMaxima);
    }
}
