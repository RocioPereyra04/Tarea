import java.time.LocalDate;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner cargar = new Scanner(System.in);// Scanner para entrada de datos

        tablasDispersion tablas = new tablasDispersion(); // Instancia de la tabla dispersa

        int op;
        do {
            // Menú principal
            System.out.println("--------------------");
            System.out.println("--- MENÚ DE TAREAS ---");
            System.out.println("1. Agregar Tarea");
            System.out.println("2. Buscar Tarea");
            System.out.println("3. Eliminar Tarea");
            System.out.println("4. Mostrar tareas");
            System.out.println("5. Salir");
            System.out.print("Ingresar la opción que desee: ");
            op = cargar.nextInt();
            cargar.nextLine(); // Limpia el buffer del scanner

            switch (op) {
                case 1: // Agregar nueva tarea
                    System.out.println("-- AGREGAR TAREA --");

                    System.out.print("Nombre de tarea: ");
                    String nombre = cargar.nextLine();

                    System.out.print("Descripción: ");
                    String descripcion = cargar.nextLine();

                    System.out.print("Estado (Pendiente, En progreso, Finalizada): ");
                    String estado = cargar.nextLine();

                    System.out.print("Fecha de Inicio (AAAA-MM-DD): ");
                    LocalDate fechaI = LocalDate.parse(cargar.nextLine());

                    System.out.print("Fecha Final (AAAA-MM-DD): ");
                    LocalDate fechaF = LocalDate.parse(cargar.nextLine());

                    // Crear nueva tarea e insertarla en la tabla
                    Tareas nueva = new Tareas(nombre, descripcion, estado, fechaI, fechaF);
                    if (tablas.insertar(nueva)) {
                        System.out.println("Tarea insertada. Código: " + nueva.getCodigo());
                    } else {
                        System.out.println("No se pudo insertar (tabla llena).");
                    }
                    break;

                case 2: // Buscar tarea por código
                    if (tablas.estaVacia()) {
                        System.out.println("No hay tareas registradas.");
                        break;
                    }
                    System.out.print("Código de tarea a buscar: ");
                    String codBuscar = cargar.nextLine();
                    Tareas encontrada = tablas.buscar(codBuscar);

                    if (encontrada != null) {
                        System.out.println("Tarea encontrada:\n" + encontrada);
                    } else {
                        System.out.println("No se encontró la tarea.");
                    }
                    break;

                case 3:
                    if (tablas.estaVacia()) {
                        System.out.println("No hay tareas registradas.");
                        break;
                    }
                    System.out.print("Código de tarea a eliminar: ");
                    String codEliminado = cargar.nextLine();
                    if (tablas.eliminar(codEliminado)) {
                        System.out.println("Tarea eliminada (Tarea dada de baja).");
                    } else {
                        System.out.println("Tarea no encontrada.");
                    }
                    break;

                case 4:
                    if (tablas.estaVacia()) {
                        System.out.println("No hay tareas registradas.");
                        break;
                    }
                    tablas.mostrarTabla();
                    break;

                case 5:
                    System.out.println("Gracias por usar el sistema.");
                    break;

                default:
                    System.out.println("Opción inválida.");
                    System.out.println("");
            }

        } while (op != 5);
        cargar.close(); // Cierra el scanner
    }
}
