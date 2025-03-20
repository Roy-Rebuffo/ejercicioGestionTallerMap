package ejerciciogestiontallermap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

//Importar librerias para UTF-8
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class EjercicioGestionTallerMap {

    public static void main(String[] args) {
        //Try Catch para asegurar usar la codificacion UTF-8
        try {
            // Redirigimos System.out a un PrintStream con codificación UTF-8
            System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8.name()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        menu();
    }

    public static void visualizar(TreeMap<Vehiculo, Integer> vehiculo) {
        vehiculo.entrySet().forEach((m) -> {
            System.out.println("VALOR->" + m.getValue() + "\n" + "CLAVE->" + m.getKey());
        });
        
        /*
        //Visualizar con mapEntry
        for(Map.Entry<Vehiculo, Integer> e : vehiculo.entrySet()){
            System.out.println(e.getKey()+ "\t" + e.getValue());
        }
        */
    }

    public static void ceilingEntry(TreeMap<Vehiculo, Integer> vehiculo) {
        // Usamos ceilingEntry para obtener la entrada con la clave más cercana
        // que sea mayor o igual que la clave dada
        Vehiculo keyToFind = new Vehiculo("5678WAS", "Mazda", "MX-5", "2015"); // Buscamos la clave 4 o la más cercana mayor
        Map.Entry<Vehiculo, Integer> ceilingEntry = vehiculo.ceilingEntry(keyToFind);

        System.out.println("\nUso de ceilingEntry con clave " + keyToFind + ":");
        System.out.println("Clave -> " + ceilingEntry.getKey() + "\tValor ->"
                + " " + ceilingEntry.getValue());
    }

    public static void higherEntry(TreeMap<Vehiculo, Integer> vehiculo) {
        Vehiculo keyToFind = new Vehiculo("5678WAS", "Mazda", "MX-5", "2015"); // Buscamos la clave 4 o la más cercana mayor
        Map.Entry<Vehiculo, Integer> higherEntry = vehiculo.higherEntry(keyToFind);

        System.out.println("\nUso de higherEntry con clave " + keyToFind + ":");
        System.out.println("Clave -> " + higherEntry.getKey() + "\tValor ->"
                + " " + higherEntry.getValue());
    }

    public static void firstEntry(TreeMap<Vehiculo, Integer> vehiculo) {
        Map.Entry<Vehiculo, Integer> firsEntry = vehiculo.firstEntry();

        System.out.println("El primer entry de la coleccion es: " + firsEntry);
    }

    public static void floorEntry(TreeMap<Vehiculo, Integer> vehiculo) {
        Vehiculo keyToFind = new Vehiculo("5678WAS", "Mazda", "MX-5", "2015"); // Buscamos la clave 4 o la más cercana mayor
        Map.Entry<Vehiculo, Integer> floorEntry = vehiculo.floorEntry(keyToFind);

        System.out.println("\nUso de floorEntry con clave " + keyToFind + ":");
        System.out.println("Clave -> " + floorEntry.getKey() + "\tValor ->"
                + " " + floorEntry.getValue());
    }

    public static void reparar(Scanner dato, TreeMap<Vehiculo, Integer> vehiculo) {
        boolean encontrado = false;

        System.out.println("ESTÁ A PUNTO DE REPARAR EL COCHE...\n");
        System.out.println("┌─────────────────────────────────────────────────────┐");
        System.out.println("│       Datos del vehículo a reparar        │");
        System.out.println("└─────────────────────────────────────────────────────┘");
        System.out.print("Introduzca la matrícula del vehículo: ");
        String matricula = dato.next();

        for (Map.Entry<Vehiculo, Integer> m : vehiculo.entrySet()) {
            Vehiculo vehiculoKey = m.getKey(); // Obtenemos la clave (Vehiculo)
            Integer vehiculoValue = m.getValue(); //Obtenemos el valor

            // Comprobamos si la matrícula del vehículo coincide
            if (vehiculoKey.getMatricula().equalsIgnoreCase(matricula)) {
                // Si el vehículo existe, incrementar el número de reparaciones
                //vehiculoValue;
                vehiculoValue ++;
                // Actualizamos el valor del vehículo en el TreeMap
                vehiculo.replace(vehiculoKey, vehiculoValue);
                
                System.out.println("¡Vehículo encontrado! Incrementamos el número de reparaciones del vehículo '"
                        + vehiculoKey.getMarca() + " " + vehiculoKey.getModelo() + "' con matrícula '"
                        + vehiculoKey.getMatricula() + "' a: " + vehiculoValue);
                encontrado = true;
                break; // Salir del bucle, ya que encontramos el vehículo
            }
        }

        if (!encontrado) {
            // Si el vehículo no existe, pedimos los datos del vehículo
            System.out.print("Vehículo no encontrado. Proceda a ingresar los datos del nuevo vehículo:\n");
            System.out.print("Introduzca la marca del vehículo: ");
            String marca = dato.next();
            System.out.print("Introduzca el modelo del vehículo: ");
            String modelo = dato.next();
            System.out.print("Introduzca la fecha de matriculación del vehículo: ");
            String fechaMatr = dato.next();

            // Añadir el nuevo vehículo a la lista
            Vehiculo nuevoVehiculo = new Vehiculo(matricula, marca, modelo, fechaMatr);
            vehiculo.put(nuevoVehiculo,1);
            System.out.println("¡Nuevo coche añadido al taller!");
        }
    }

    //Primer menu
    public static void menu() {
        //Creo una coleccion de prueba para ya tener vehículos en el taller
        TreeMap<Vehiculo, Integer> vehiculo = new TreeMap<>();
        //Creo los objetos
        Vehiculo v1 = new Vehiculo("5678WAS", "Mazda", "MX-5", "2015");
        Vehiculo v2 = new Vehiculo("8765GLD", "Renault", "Clio", "2022");
        Vehiculo v3 = new Vehiculo("1234ABC", "Paganni", "Zonda", "2008");
        Vehiculo v4 = new Vehiculo("4321CBA", "Ferrari", "Enzo", "2006");

        vehiculo.put(v1, 1);
        vehiculo.put(v2, 1);
        vehiculo.put(v3, 1);
        vehiculo.put(v4, 1);

        Scanner dato = new Scanner(System.in);
        int opcion = -1;
        limpiarConsola();
        while (opcion != 0) {
            System.out.println("\t\t╔════════════════════════════════════════════════════════╗");
            System.out.println("\t\t║        BIENVENIDO AL TALLER                  ║");
            System.out.println("\t\t╠════════════════════════════════════════════════════════╣");
            System.out.println("\t\t║    (1) VISUALIZAR VEHICULOS                  ║");
            System.out.println("\t\t║    (2) CEILING ENTRY                         ║");
            System.out.println("\t\t║    (3) HIGHER ENTRY                          ║");
            System.out.println("\t\t║    (4) FIRST ENTRY                           ║");
            System.out.println("\t\t║    (5) FLOOR ENTRY                           ║");
            System.out.println("\t\t║    (6) REPARAR                               ║");
            System.out.println("\t\t║    (0) SALIR DEL TALLER                      ║");
            System.out.println("\t\t╚════════════════════════════════════════════════════════╝");

            System.out.print("\n\t\t⭐Seleccione la opción elegida: ⭐");
            opcion = dato.nextInt();
            limpiarConsola();
            switch (opcion) {
                case 1:
                    visualizar(vehiculo);
                    break;
                case 2:
                    ceilingEntry(vehiculo);
                    break;
                case 3:
                    higherEntry(vehiculo);
                    break;
                case 4:
                    firstEntry(vehiculo);
                    break;
                case 5:
                    floorEntry(vehiculo);
                    break;
                case 6:
                    reparar(dato, vehiculo);
                    break;
                case 0:
                    System.out.println("\nSaliendo del taller... Vuelva pronto!");
                    break;
                default:
                    System.out.println("Elija un número entre 1 y 2, en caso "
                            + "de salir 0.");
                    break;
            }
        }
    }

    public static void limpiarConsola() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

}
