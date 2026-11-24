import java.util.ArrayList;
import java.util.Scanner;
 
/**
 * Coloquio Integrador - Programación Procedural
 * Integrantes: Alejandro Muñoz, Fernando Flores, Mariano Cortez, Agustín Videla
 */
public class ColoquioApp {
 
    // UNIDAD 1 (Alejandro Muñoz): constante (final) y variable global de clase
    public static final String SISTEMA = "Gestión Modular";
 
    // UNIDAD 2B (Mariano Cortez): arreglo estático (tamaño fijo, no se redimensiona)
    public static final String[] OPCIONES = {"Cargar ítem", "Listar ítems", "Calcular total", "Salir"};
 
    // UNIDAD 3 (Agustín Videla): procedimiento (void) que ejecuta una acción sin devolver valor
    public static void mostrarMenu() {
        System.out.println("\n=== " + SISTEMA + " ===");
        // UNIDAD 2A (Fernando Flores): bucle for sobre el arreglo estático
        for (int i = 0; i < OPCIONES.length; i++) {
            System.out.println((i + 1) + ". " + OPCIONES[i]);
        }
        System.out.print("Opción: ");
    }
 
    // UNIDAD 3 (Agustín Videla): función con retorno (double) y pasaje de parámetros por valor
    public static double calcularTotal(double precio, int cantidad) {
        return precio * cantidad;
    }
 
    // UNIDAD 3 (Agustín Videla): pasaje por referencia. Se copia la referencia a la lista (Heap),
    // por eso el cambio persiste fuera del método.
    public static void agregarItem(ArrayList<String> lista, String nombre) {
        lista.add(nombre);
    }
 
    // UNIDAD 1 (Alejandro Muñoz): lectura con Scanner + Integer.parseInt con validación
    public static int leerEntero(Scanner teclado) {
        while (true) {
            try {
                return Integer.parseInt(teclado.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Valor inválido. Ingrese un número entero: ");
            }
        }
    }
 
    // UNIDAD 1 (Alejandro Muñoz): acepta punto o coma como separador decimal
    public static double leerDecimal(Scanner teclado) {
        while (true) {
            try {
                return Double.parseDouble(teclado.nextLine().trim().replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.print("Valor inválido. Ingrese un número (ej. 10.5): ");
            }
        }
    }
 
    public static void main(String[] args) {
        // UNIDAD 1: tipos primitivos, referencia (String) y lectura con Scanner
        Scanner teclado = new Scanner(System.in);
 
        // UNIDAD 2B: estructura de datos dinámica (ArrayList) frente al arreglo fijo
        ArrayList<String> items = new ArrayList<>();
        int opcion;
 
        // UNIDAD 2A: bucle do-while (se ejecuta al menos una vez). La opción 4 es el valor centinela.
        do {
            mostrarMenu();
            opcion = leerEntero(teclado);
 
            // UNIDAD 2A: selección múltiple (switch) con salto (break)
            switch (opcion) {
                case 1:
                    System.out.print("Nombre del ítem: ");
                    agregarItem(items, teclado.nextLine());
                    System.out.println("Guardado.");
                    break;
                case 2:
                    // UNIDAD 2A: selección doble (if-else) y bucle for con ArrayList
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
                    double precio = leerDecimal(teclado);
                    System.out.print("Cantidad: ");
                    int cant = leerEntero(teclado);
                    System.out.println("Total: $" + calcularTotal(precio, cant));
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 4);
 
        teclado.close();
    }
}