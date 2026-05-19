package app;

import model.*;
import service.TallerService;
import utils.Consola;
import exceptions.EquipoNoEncontradoException;

public class Main {

    public static void main(String[] args) {

        TallerService taller = new TallerService();

        Tecnico tecnico =
                new Tecnico(
                        "Carlos",
                        "123",
                        "300123456",
                        "Robótica"
                );

        int opcion;

        do {

            System.out.println("\n===== TALLER MECATRÓNICO =====");

            System.out.println("1. Registrar Cliente");
            System.out.println("2. Registrar Robot");
            System.out.println("3. Registrar Dron");
            System.out.println("4. Crear Orden");
            System.out.println("5. Mostrar Órdenes");
            System.out.println("6. Buscar Equipo");
            System.out.println("7. Reparar Equipo");
            System.out.println("0. Salir");

            opcion = Consola.sc.nextInt();
            Consola.sc.nextLine();

            switch (opcion) {

                case 1:
                    try {
                        String nombre = solicitarTexto("Nombre: ");
                        String doc = solicitarTexto("Documento: ");
                        String tel = solicitarTexto("Teléfono: ");
                        String codigo = solicitarTexto("Código Cliente: ");

                        Cliente cliente =
                                new Cliente(nombre, doc, tel, codigo);

                        taller.registrarCliente(cliente);
                        System.out.println("Cliente registrado.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        String serialRobot = solicitarTexto("Serial: ");
                        String marcaRobot = solicitarTexto("Marca: ");
                        int sensores = solicitarEnteroNoNegativo("Cantidad sensores: ");

                        Robot robot =
                                new Robot(
                                        serialRobot,
                                        marcaRobot,
                                        "Dañado",
                                        sensores
                                );

                        taller.registrarEquipo(robot);
                        System.out.println("Robot registrado.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        String serialDron = solicitarTexto("Serial: ");
                        String marcaDron = solicitarTexto("Marca: ");
                        double altura = solicitarDoubleNoNegativo("Altura máxima: ");

                        Dron dron =
                                new Dron(
                                        serialDron,
                                        marcaDron,
                                        "Dañado",
                                        altura
                                );

                        taller.registrarEquipo(dron);
                        System.out.println("Dron registrado.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        String codigoClienteOrden = solicitarTexto("Código cliente: ");
                        Cliente clienteOrden =
                                taller.buscarCliente(codigoClienteOrden);

                        String serialEquipoOrden = solicitarTexto("Serial del equipo: ");
                        Equipo equipoOrden =
                                taller.buscarEquipo(serialEquipoOrden);

                        String descripcionFalla = solicitarTexto("Descripción de la falla: ");
                        double costoOrden = solicitarDoubleNoNegativo("Costo: ");

                        OrdenServicio orden = new OrdenServicio(
                                clienteOrden,
                                equipoOrden,
                                tecnico,
                                descripcionFalla,
                                costoOrden
                        );

                        taller.crearOrden(orden);
                        System.out.println("Orden creada.");
                    } catch (EquipoNoEncontradoException | IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:

                    taller.mostrarOrdenes();
                    break;

                case 6:

                    try {

                        System.out.print("Serial: ");
                        String serial = Consola.sc.nextLine();

                        Equipo equipo =
                                taller.buscarEquipo(serial);

                        equipo.mostrarInfo();

                    } catch (EquipoNoEncontradoException e) {

                        System.out.println(e.getMessage());
                    }

                    break;

                case 7:

                    try {

                        System.out.print("Serial: ");
                        String serial = Consola.sc.nextLine();

                        Equipo equipo =
                                taller.buscarEquipo(serial);

                        equipo.reparar();

                    } catch (EquipoNoEncontradoException e) {

                        System.out.println(e.getMessage());
                    }

                    break;

                case 0:

                    System.out.println("Saliendo...");
                    break;

                default:

                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }

    private static String solicitarTexto(String mensaje) {
        String valor;

        do {
            System.out.print(mensaje);
            valor = Consola.sc.nextLine();
            if (valor == null || valor.trim().isEmpty()) {
                System.out.println("El campo no puede estar vacío. Intenta nuevamente.");
            }
        } while (valor == null || valor.trim().isEmpty());

        return valor.trim();
    }

    private static int solicitarEnteroNoNegativo(String mensaje) {
        Integer valor = null;

        while (valor == null) {
            System.out.print(mensaje);
            String linea = Consola.sc.nextLine();

            if (linea == null || linea.trim().isEmpty()) {
                System.out.println("El campo no puede estar vacío. Intenta nuevamente.");
                continue;
            }

            try {
                valor = Integer.parseInt(linea.trim());
                if (valor < 0) {
                    System.out.println("El valor no puede ser negativo. Intenta nuevamente.");
                    valor = null;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingresa un número entero.");
            }
        }

        return valor;
    }

    private static double solicitarDoubleNoNegativo(String mensaje) {
        Double valor = null;

        while (valor == null) {
            System.out.print(mensaje);
            String linea = Consola.sc.nextLine();

            if (linea == null || linea.trim().isEmpty()) {
                System.out.println("El campo no puede estar vacío. Intenta nuevamente.");
                continue;
            }

            try {
                valor = Double.parseDouble(linea.trim());
                if (valor < 0) {
                    System.out.println("El valor no puede ser negativo. Intenta nuevamente.");
                    valor = null;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingresa un número.");
            }
        }

        return valor;
    }
}
