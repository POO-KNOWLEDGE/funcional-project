package service;

import model.*;
import exceptions.DuplicadoException;
import exceptions.EquipoNoEncontradoException;

import java.util.ArrayList;

public class TallerService {

    private ArrayList<Cliente> clientes;
    private ArrayList<Equipo> equipos;
    private ArrayList<OrdenServicio> ordenes;

    public TallerService() {

        clientes = new ArrayList<>();
        equipos = new ArrayList<>();
        ordenes = new ArrayList<>();
    }

    public void registrarCliente(Cliente cliente) {
        for (Cliente existente : clientes) {
            if (existente.getDocumento().equals(cliente.getDocumento())) {
                throw new DuplicadoException(
                        "Ya existe una persona con ese documento."
                );
            }
        }
        clientes.add(cliente);
    }

    public void registrarEquipo(Equipo equipo) {
        for (Equipo existente : equipos) {
            if (existente.getSerial().equals(equipo.getSerial())) {
                throw new DuplicadoException(
                        "Ya existe un equipo con ese serial."
                );
            }
        }
        equipos.add(equipo);
    }

    public void crearOrden(OrdenServicio orden) {
        ordenes.add(orden);
    }

    public void mostrarOrdenes() {

        if (ordenes.isEmpty()) {
            System.out.println("No hay ordenes.");
            return;
        }

        for (OrdenServicio orden : ordenes) {
            orden.mostrarOrden();
        }
    }

    public Cliente buscarCliente(String codigo)
            throws IllegalArgumentException {

        for (Cliente cliente : clientes) {
            if (cliente.getCodigoCliente().equals(codigo)) {
                return cliente;
            }
        }

        throw new IllegalArgumentException(
                "No existe un cliente con ese código."
        );
    }

    public Equipo buscarEquipo(String serial)
            throws EquipoNoEncontradoException {

        for (Equipo equipo : equipos) {

            if (equipo.getSerial().equals(serial)) {
                return equipo;
            }
        }

        throw new EquipoNoEncontradoException(
                "No existe un equipo con ese serial."
        );
    }
}
