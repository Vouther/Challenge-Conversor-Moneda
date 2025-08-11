package conversor;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final Map<Integer, String[]> OPCIONES = Map.of(
            1, new String[]{"USD", "ARS"},
            2, new String[]{"ARS", "USD"},
            3, new String[]{"USD", "BRL"},
            4, new String[]{"BRL", "USD"},
            5, new String[]{"USD", "COP"},
            6, new String[]{"COP", "USD"}
    );

    public static void main(String[] args) {
        try (Scanner lectura = new Scanner(System.in)) {
            ConsultaApi consulta = new ConsultaApi();
            while (true) {
                mostrarMenu();
                int opcion = leerEntero(lectura);
                if (opcion == 7) break;

                if (!OPCIONES.containsKey(opcion)) {
                    System.out.println("Opción inválida.");
                    continue;
                }

                float cantidad = leerFloat(lectura);
                String[] monedas = OPCIONES.get(opcion);
                try {
                    Conversion conversion = consulta.convertirMoneda(monedas[0], monedas[1], cantidad);
                    System.out.println(conversion);
                } catch (RuntimeException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("""
                ***************************************
                Sea bienvenido/a al conversor de monedas
                1) Dólar => Peso Argentino
                2) Peso Argentino => Dólar
                3) Dólar => Real Brasileño
                4) Real Brasileño => Dólar
                5) Dólar => Peso Colombiano
                6) Peso Colombiano => Dólar
                7) Salir
                ***************************************
                """);
    }

    private static int leerEntero(Scanner sc) {
        while (true) {
            System.out.print("Elija una opción válida: ");
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número entero.");
                sc.nextLine(); // limpiar buffer
            }
        }
    }

    private static float leerFloat(Scanner sc) {
        while (true) {
            System.out.print("Ingrese la cantidad a convertir: ");
            try {
                return sc.nextFloat();
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número válido.");
                sc.nextLine(); // limpiar buffer
            }
        }
    }
}
