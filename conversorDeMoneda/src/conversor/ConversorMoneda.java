package conversor;
import java.util.Scanner;

public class ConversorMoneda {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("*******************************************************");
            System.out.println("Sea bienvenido al conversor de moneda =]");
            System.out.println();
            System.out.println("1) Dólar => Peso argentino");
            System.out.println("2) Peso argentino => Dólar");
            System.out.println("3) Dólar => Real brasileño");
            System.out.println("4) Real brasileño => Dólar");
            System.out.println("5) Dólar => Peso colombiano");
            System.out.println("6) Peso colombiano => Dólar");
            System.out.println("7) Salir");
            System.out.println("Elija una opción válida:");
            System.out.println("*******************************************************");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el valor que desea convertir (Dólares => Pesos):");
                    double valorDolares = scanner.nextDouble();
                    double tasaDolarAPeso = APIService.obtenerTasaCambio("USD", "ARS");
                    if (tasaDolarAPeso != -1) {
                        System.out.println("Valor en pesos: " + valorDolares * tasaDolarAPeso);
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el valor que desea convertir (Pesos => Dólares):");
                    double valorPesos = scanner.nextDouble();
                    double tasaPesoADolar = APIService.obtenerTasaCambio("ARS", "USD");
                    if (tasaPesoADolar != -1) {
                        System.out.println("Valor en dólares: " + valorPesos * tasaPesoADolar);
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el valor que desea convertir (Dólares => Reales):");
                    double valorDolaresReal = scanner.nextDouble();
                    double tasaDolarAReal = APIService.obtenerTasaCambio("USD", "BRL");
                    if (tasaDolarAReal != -1) {
                        System.out.println("Valor en reales: " + valorDolaresReal * tasaDolarAReal);
                    }
                    break;
                case 4:
                    System.out.println("Ingrese el valor que desea convertir (Reales => Dólares):");
                    double valorReales = scanner.nextDouble();
                    double tasaRealADolar = APIService.obtenerTasaCambio("BRL", "USD");
                    if (tasaRealADolar != -1) {
                        System.out.println("Valor en dólares: " + valorReales * tasaRealADolar);
                    }
                    break;
                case 5:
                    System.out.println("Ingrese el valor que desea convertir (Dólares => Pesos colombianos):");
                    double valorDolaresColombianos = scanner.nextDouble();
                    double tasaDolarAPesoColombiano = APIService.obtenerTasaCambio("USD", "COP");
                    if (tasaDolarAPesoColombiano != -1) {
                        System.out.println("Valor en pesos colombianos: " + valorDolaresColombianos * tasaDolarAPesoColombiano);
                    }
                    break;
                case 6:
                    System.out.println("Ingrese el valor que desea convertir (Pesos colombianos => Dólares):");
                    double valorPesosColombianos = scanner.nextDouble();
                    double tasaPesoColombianoADolar = APIService.obtenerTasaCambio("COP", "USD");
                    if (tasaPesoColombianoADolar != -1) {
                        System.out.println("Valor en dólares: " + valorPesosColombianos * tasaPesoColombianoADolar);
                    }
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }

        } while (opcion != 7);

        scanner.close();
    }
}
