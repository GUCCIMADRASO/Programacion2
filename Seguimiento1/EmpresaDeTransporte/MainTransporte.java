import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class MainTransporte {

    public static void main(String[] args) {
        LinkedList<VehiculoTransporte> vehiculoTransportes = new LinkedList<>();
        LinkedList<Propietario> propietarios = new LinkedList<>();
        LinkedList<Usuario> usuarios = new LinkedList<>();
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        while (!salir) {
            mostrarMenu();

            try {
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        crearPropietarioYVehiculoCarga(propietarios);
                        break;
                    case 2:
                        crearVehiculosTransporte(vehiculoTransportes,usuarios);
                        break;
                    case 3:
                        calcularPasajerosTransportados(vehiculoTransportes);
                        break;
                    case 4:
                        mostrarDatosDePrueba();
                        break;
                    case 5:
                        usuariosConSobrepeso(vehiculoTransportes);
                        break;
                    case 6:
                        contarPropietariosMayoresDe40(propietarios);
                        break;
                    case 7:
                        contarUsuariosEnRangoDeEdad(vehiculoTransportes);
                        break;
                    case 8:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 8");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("1. Crear un propietario y su vehiculo de carga");
        System.out.println("2. Crear vehiculos de transporte");
        System.out.println("3. Calcular el total de pasajeros transportados en un dia");
        System.out.println("4. Mostrar datos de prueba para la clase Empresa de Transporte");
        System.out.println("5. Buscar usuarios con sobrepeso");
        System.out.println("6. Contar propietarios mayores a 40 años");
        System.out.println("7. Contar usuarios en rango de edad");
        System.out.println("8. Salir");
        System.out.println("Escribe una de las opciones: ");
    }

    private static void crearPropietarioYVehiculoCarga(LinkedList<Propietario> propietarios) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Has seleccionado la opción 1 (Crear un propietario y su vehículo de carga)");
        VehiculoCarga vehiculoCarga = new VehiculoCarga(
                obtenerDato(scanner, "Ingrese la placa del vehículo: "),
                obtenerDato(scanner, "Ingrese el modelo del vehículo: "),
                obtenerDato(scanner, "Ingrese la marca del vehículo: "),
                obtenerDato(scanner, "Ingrese el color del vehículo: "),
                Double.parseDouble(obtenerDato(scanner, "Ingrese la capacidad máxima del vehículo de carga: ")),
                Integer.parseInt(obtenerDato(scanner, "Ingrese el número de ejes del vehículo de carga: "))
        );

        Propietario propietario = new Propietario(
                obtenerDato(scanner, "Ingrese el nombre del propietario: "),
                Integer.parseInt(obtenerDato(scanner, "Ingrese la edad del propietario: ")),
                obtenerDato(scanner, "Ingrese la cédula del propietario: "),
                obtenerDato(scanner, "Ingrese el email del propietario: "),
                obtenerDato(scanner, "Ingrese el celular del propietario: "),
                vehiculoCarga
        );
        propietarios.add(propietario);

        System.out.println("Se creó con éxito el propietario con los datos: " + propietario);
        System.out.println("Y se creó con éxito el vehículo de carga con los datos: " + vehiculoCarga + vehiculoCarga.toString1());
    }

    private static void crearVehiculosTransporte(LinkedList<VehiculoTransporte> vehiculoTransportes,LinkedList<Usuario> usuarios) {
        Scanner scanner = new Scanner(System.in);
        generarDatosListasUsuarios(usuarios);
        System.out.println("Has seleccionado la opción 2 (Crear vehículos de transporte)");
        int numeroVehiculosTransportes = Integer.parseInt(obtenerDato(scanner,"Ingrese el numero de vehículos de transporte que desea crear: "));

        for (int i = 0; i < numeroVehiculosTransportes; i++) {
            VehiculoTransporte vehiculoTransporte = new VehiculoTransporte(
                    obtenerDato(scanner, "Ingrese la placa del vehículo: "),
                    obtenerDato(scanner, "Ingrese el modelo del vehículo: "),
                    obtenerDato(scanner, "Ingrese la marca del vehículo: "),
                    obtenerDato(scanner, "Ingrese el color del vehículo: "),
                    Integer.parseInt(obtenerDato(scanner, "Ingrese el máximo de usuarios del vehículo: "))
            );

            for (int j = 0; j < usuarios.size() && j < vehiculoTransporte.getMaxPasajeros(); j++) {
                vehiculoTransporte.getUsuarios()[j] = usuarios.get(j);
            }

            vehiculoTransportes.add(vehiculoTransporte);
        }
    }

    private static void calcularPasajerosTransportados(LinkedList<VehiculoTransporte> vehiculoTransportes) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Has seleccionado la opción 3 (Calcular el total de pasajeros transportados en un día)");
        String placa = obtenerDato(scanner, "Ingrese la placa del vehículo a consultar: ");

        for (VehiculoTransporte vehiculoTransporte : vehiculoTransportes) {
            if (vehiculoTransporte.getPlaca().equalsIgnoreCase(placa)) {
                System.out.println("El número de pasajeros del vehículo con la placa " + placa + " es: " + vehiculoTransporte.getUsuarios().length);
                System.out.println("Y los datos de cada pasajero son: " + vehiculoTransporte.datosUsuarios());
            }
        }
    }
    private static void usuariosConSobrepeso(LinkedList<VehiculoTransporte> vehiculoTransportes) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Has seleccionado la opcion 5 (Buscar usuarios con sobrepeso)");
        double peso = Double.parseDouble(obtenerDato(scanner, "Ingrese el peso maximo: "));
        LinkedList<Usuario> usuariosConSobrepeso = new LinkedList<>();

        for (VehiculoTransporte vehiculoTransporte : vehiculoTransportes) {
            for (Usuario usuario : vehiculoTransporte.getUsuarios()) {
                if (usuario.getPeso() > peso) {
                    usuariosConSobrepeso.add(usuario);
                }
            }
        }
        if (usuariosConSobrepeso.isEmpty()) {
            System.out.println("No se encontraron usuarios con sobrepeso.");
        } else {
            System.out.println("Los usuarios con sobrepeso son: " + usuariosConSobrepeso);
        }

    }
    private static void contarPropietariosMayoresDe40(LinkedList<Propietario> propietarios) {
        generarDatosListasPropietarios(propietarios);
        System.out.println("Has seleccionado la opción 6 (Contar propietarios mayores a 40 años)");
        int contador = 0;

        for (Propietario propietario : propietarios) {
            if (propietario.getEdad() > 40) {
                contador++;
            }
        }

        System.out.println("El número de propietarios mayores de 40 años es: " + contador);
    }
    private static void contarUsuariosEnRangoDeEdad(LinkedList<VehiculoTransporte> vehiculoTransportes) {
        System.out.println("Has seleccionado la opción 7 (Contar usuarios en rango de edad)");
        Scanner scanner = new Scanner(System.in);
        int contador = 0;
        int edadMinima = Integer.parseInt(obtenerDato(scanner,"Ingrese la edad minima: "));
        int edadMaxima = Integer.parseInt(obtenerDato(scanner,"Ingrese la edad maxima: "));

        for (VehiculoTransporte vehiculoTransporte : vehiculoTransportes){
            for (Usuario usuario : vehiculoTransporte.getUsuarios()) {
                int edad = Integer.parseInt(usuario.getEdad());
                if (edad >= edadMinima && edad <= edadMaxima) {
                    contador++;
                }
            }
        }

        System.out.println("El número de usuarios en el rango de edad [" + edadMinima + ", " + edadMaxima + "] es: " + contador);
    }

    private static String obtenerDato(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.next();
    }
    public static void generarDatosListasUsuarios(LinkedList<Usuario> usuarios) {
        usuarios.add(new Usuario("Carl", "21",70));
        usuarios.add(new Usuario("Camilo", "20",75));
        usuarios.add(new Usuario("Cesar", "27",80));
        usuarios.add(new Usuario("Daniel", "18",75));
    }
    public static void generarDatosListasPropietarios(LinkedList<Propietario> propietarios) {
        propietarios.add(new Propietario("Juan Perez",50, "123456789", "juan@example.com", "3001234567"));
        propietarios.add(new Propietario("Maria Gomez",35, "987654321", "maria@example.com", "3009876543"));
        propietarios.add(new Propietario("Carlos Ruiz",22, "112233445", "carlos@example.com", "3001122334"));
        propietarios.add(new Propietario("Ana Martinez",45, "556677889", "ana@example.com", "3005566778"));
    }
    //Datos de prueba
    public static EmpresaTransporte crearDatosDePrueba() {
        EmpresaTransporte empresaTransporte = new EmpresaTransporte();

        // Crear vehículos de carga
        VehiculoCarga vehiculoCarga1 = new VehiculoCarga("ABC123", "F-150", "Ford", "Rojo", 1500.5, 2);
        VehiculoCarga vehiculoCarga2 = new VehiculoCarga("DEF456", "Ram 2500", "Dodge", "Negro", 2000.0, 4);
        VehiculoCarga vehiculoCarga3 = new VehiculoCarga("GHI789", "Tundra", "Toyota", "Blanco", 1800.7, 3);
        VehiculoCarga vehiculoCarga4 = new VehiculoCarga("JKL012", "Silverado", "Chevrolet", "Azul", 2200.2, 4);

        empresaTransporte.getVehiculosCarga().add(vehiculoCarga1);
        empresaTransporte.getVehiculosCarga().add(vehiculoCarga2);
        empresaTransporte.getVehiculosCarga().add(vehiculoCarga3);
        empresaTransporte.getVehiculosCarga().add(vehiculoCarga4);

        // Crear vehículos de transporte
        VehiculoTransporte vehiculoTransporte1 = new VehiculoTransporte("MNO345", "Sprinter", "Mercedes-Benz", "Plata", 15);
        VehiculoTransporte vehiculoTransporte2 = new VehiculoTransporte("PQR678", "Hiace", "Toyota", "Blanco", 12);
        VehiculoTransporte vehiculoTransporte3 = new VehiculoTransporte("STU901", "Transit", "Ford", "Negro", 10);
        VehiculoTransporte vehiculoTransporte4 = new VehiculoTransporte("VWX234", "Ducato", "Fiat", "Gris", 14);

        empresaTransporte.getVehiculosTransporte().add(vehiculoTransporte1);
        empresaTransporte.getVehiculosTransporte().add(vehiculoTransporte2);
        empresaTransporte.getVehiculosTransporte().add(vehiculoTransporte3);
        empresaTransporte.getVehiculosTransporte().add(vehiculoTransporte4);

        // Crear propietarios
        Propietario propietario1 = new Propietario("Juan Perez",50, "123456789", "juan@example.com", "3001234567", vehiculoCarga1);
        Propietario propietario2 = new Propietario("Maria Gomez",35, "987654321", "maria@example.com", "3009876543", vehiculoCarga2);
        Propietario propietario3 = new Propietario("Carlos Ruiz",22, "112233445", "carlos@example.com", "3001122334", vehiculoCarga3);
        Propietario propietario4 = new Propietario("Ana Martinez",45, "556677889", "ana@example.com", "3005566778", vehiculoCarga4);

        empresaTransporte.getPropietarios().add(propietario1);
        empresaTransporte.getPropietarios().add(propietario2);
        empresaTransporte.getPropietarios().add(propietario3);
        empresaTransporte.getPropietarios().add(propietario4);

        // Crear usuarios
        Usuario usuario1 = new Usuario("Pedro Lopez", "25",65, vehiculoTransporte1);
        Usuario usuario2 = new Usuario("Luisa Fernandez", "30",70, vehiculoTransporte2);
        Usuario usuario3 = new Usuario("Jose Ramirez", "40",68, vehiculoTransporte3);
        Usuario usuario4 = new Usuario("Sandra Ortiz", "35",70, vehiculoTransporte4);

        empresaTransporte.getUsuarios().add(usuario1);
        empresaTransporte.getUsuarios().add(usuario2);
        empresaTransporte.getUsuarios().add(usuario3);
        empresaTransporte.getUsuarios().add(usuario4);

        return empresaTransporte;
    }

    private static void mostrarDatosDePrueba() {
        EmpresaTransporte empresaTransporte = crearDatosDePrueba();
        System.out.println("Has seleccionado la opción 4 (Mostrar datos de prueba para la clase Empresa de Transporte)");

        // Prueba: Mostrar datos de prueba creados
        System.out.println("Propietarios:");
        empresaTransporte.getPropietarios().forEach(propietario -> System.out.println(propietario.toString()));

        System.out.println("\nUsuarios:");
        empresaTransporte.getUsuarios().forEach(usuario -> System.out.println(usuario.toString()));

        System.out.println("\nVehículos de Carga:");
        empresaTransporte.getVehiculosCarga().forEach(vehiculo -> System.out.println(vehiculo.toString()));

        System.out.println("\nVehículos de Transporte:");
        empresaTransporte.getVehiculosTransporte().forEach(vehiculo -> System.out.println(vehiculo.toString()));
    }
}
