package gestioncalificaciones;

import java.util.Scanner;

public class GestionCalificaciones {

    static Scanner scanner = new Scanner(System.in);
    static String nombreEstudiantes[];
    static int calificaciones[][];
    static int numEstudiantes;
    static int numCalificaciones;

    public static void agregarEstudiantes() {
        System.out.println("INGRESE EL NOMBRE DEL NUEVO ESTUDIANTE: ");
        scanner.nextLine();
        String nombre = scanner.nextLine();

        for (int f = 0; f < numEstudiantes; f++) {
            if (nombreEstudiantes[f] == null) {
                nombreEstudiantes[f] = nombre;
                System.out.println("INGRESE LAS CALIFICACIONES DEL ESTUDIANTE: " + (nombre) + ":");
                for (int c = 0; c < numCalificaciones; c++) {
                    System.out.println("ASIGNATURA: " + (c + 1));
                    calificaciones[f][c] = scanner.nextInt();
                }
                scanner.nextLine();
                return;
            }
        }
        System.out.println("NO SE PUEDE AGREGAR MAS ESTUDIANTES, EL LIMITE HA SIDO ALCANZADO.");
    }

    public static void buscarPorNombres() {
        System.out.println("INGRESE EL NOMBRE DEL ESTUDIANTE A BUSCAR: ");
        scanner.nextLine();
        String nombreBuscado = scanner.nextLine();
        for (int f = 0; f < numEstudiantes; f++) {
            if (nombreBuscado.equalsIgnoreCase(nombreEstudiantes[f])) {
                System.out.println("CALIFICACIONES DE: " + nombreBuscado);
                for (int c = 0; c < numCalificaciones; c++) {
                    System.out.println("ASIGNATURA: " + (c + 1) + ":" + calificaciones[f][c]);
                }
                return;

            }
        }
        System.out.println("ESTUDIANTE ENCONTRADO");
    }

    public static void eliminarEstudiantePorNombre() {
        System.out.println("INGRESE EL NOMBRE DEL ESTUDIANTE A ELIMINAR: ");
        scanner.nextLine();
        String nombreEliminar = scanner.nextLine();
        for (int f = 0; f < numEstudiantes; f++) {
            if (nombreEliminar.equalsIgnoreCase(nombreEstudiantes[f])) {
                nombreEstudiantes[f] = null;
                for (int c = 0; c < numCalificaciones; c++) {
                    calificaciones[f][c] = 0;
                }
                System.out.println("ESTUDIANTE: " + nombreEliminar + " ELIMINADO");
            }
        }
        System.out.println("ESTUDIANTE NO ENCONTRADO.");
    }

    public static void ordenarEstudiantesPorCalificaciones() {
        for (int i = 0; i < numEstudiantes; i++) {
            for (int j = 1; j < numCalificaciones; j++) {
                int temp = calificaciones[i][j];
                int k = j - 1;
                while (k > 0 && calificaciones[i][k] > temp) {
                    calificaciones[i][k + 1] = calificaciones[i][k];
                    k--;
                }
                calificaciones[i][k + 1] = temp;
            }
        }
        System.out.println("CALIFICACIONES ORDENADAS");
    }

    public static void mostrarDatos() {
        System.out.println("\n TABLA DE CALIFICACIONES");
        System.out.printf("%-20S", "NOMBRES");
        for (int i = 0; i < numCalificaciones; i++) {
            System.out.printf("ASIGNATURA: %d", (i + 1));
        }
        System.out.println();
        for (int i = 0; i < numEstudiantes; i++) {
            if (nombreEstudiantes != null) {
                System.out.printf("%-20s", nombreEstudiantes[i]);
                for (int j = 0; j < numCalificaciones; j++) {
                    System.out.printf("%d", calificaciones[i][j]);
                }
                System.out.println();
            }
        }
    }

    public static void mostrarMenu() {
        System.out.println("t/Menu"
                + "\n1. AGREGAR ESTUDIANTE"
                + "\n2. BUSCAR ESTUDIANTE POR NOMBRE"
                + "\n3. ELIMINAR ESTUDIANTE POR NOMBRE"
                + "\n4. ORDENAR POR CALIFICACIONES"
                + "\n5. MOSTRAR ESTUDIANTES"
                + "\n6. SALIR"
                + "\n SELECCIONE UNA OPCION: ");
    }

    public static void main(String[] args) {
        System.out.println("INGRESE EL NUMERO DE ESTUDIANTES: ");
        numEstudiantes = scanner.nextInt();
        System.out.println("INGRESE EL NUMERO DE ASIGNATURAS: ");
        numCalificaciones = scanner.nextInt();
        scanner.nextLine();

        nombreEstudiantes = new String[numEstudiantes];
        calificaciones = new int[numEstudiantes][numCalificaciones];
        boolean flag = true;
        while (flag) {
            mostrarMenu();
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    agregarEstudiantes();
                    break;
                case 2:
                    buscarPorNombres();
                    break;

                case 3:
                    eliminarEstudiantePorNombre();
                    break;

                case 4:
                    ordenarEstudiantesPorCalificaciones();
                    break;

                case 5:
                    mostrarDatos();
                    break;

                case 6:
                    flag = false;
                    System.out.println("SALIENDO DEL PROGRAMA...");
                    break;
                default:
                    throw new AssertionError("ERROR");
            }
        }
    }
}
