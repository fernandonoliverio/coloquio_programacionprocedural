 import java.util.ArrayList;
import java.util.Scanner;

public class ColoquioApp {
    // UNIDAD 1: Constante (final) y variable global de clase
    public static final String SISTEMA = "Gestión Modular";

    // UNIDAD 3: Procedimiento (void) que ejecuta una acción sin devolver valor
    public static void mostrarMenu() {
        System.out.println("\n=== " + SISTEMA + " ===");
        System.out.println("1. Cargar ítem | 2. Listar ítems | 3. Calcular total | 4. Salir");
    }

    // UNIDAD 3: Función con retorno (double) y pasaje de parámetros por valor
    public static double calcularTotal(double precio, int cantidad) {
        return precio * cantidad;
    }

    public static void main(String[] args) {
        // UNIDAD 1: Tipos primitivos, referencia (String) y lectura con Scanner
        Scanner teclado = new Scanner(System.in);

        // UNIDAD 2: Estructura de datos dinámica (ArrayList) vs Arreglo fijo
        ArrayList<String> items = new ArrayList<>();
        int opcion;

        // UNIDAD 2: Bucle do-while (se ejecuta al menos una vez)
        do {
            mostrarMenu();
            opcion = teclado.nextInt();
            teclado.nextLine(); // Limpieza de buffer

            // UNIDAD 2: Selección múltiple (switch) con salto (break)
            switch (opcion) {
                case 1:
                    System.out.print("Nombre del ítem: ");
                    items.add(teclado.nextLine());
                    System.out.println("Guardado.");
                    break;
                case 2:
                    // UNIDAD 2: Selección doble (if-else) y bucle determinado
                    if (items.isEmpty()) {
                        System.out.println("Lista vacía.");
                    } else {
                        for (int i = 0; i < items.size(); i++) {
                            System.out.println((i + 1) + ". " + items.get(i));
                        }
                    }
                    break;
                case 3:
                    System.out.print("Precio: ");
                    double precio = teclado.nextDouble();
                    System.out.print("Cantidad: ");
                    int cant = teclado.nextInt();
                    // Invocación de la función y asignación del retorno
                    System.out.println("Total: $" + calcularTotal(precio, cant));
                    break;
                case 4:
                    System.out.println("Saling... / Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 4);

        teclado.close();
    }
} 