import java.util.Scanner;

public class CurrencyConverterApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        APICall apiCall = new APICall();

        int choice;

        System.out.println("************************************************************************");
        System.out.println("Bienvenido, elija la conversión que desea realizar");
        while(true) {
            System.out.println("1) Dolar => Peso argentino");
            System.out.println("2) Peso argentino => Dolar ");
            System.out.println("3) Dolar => Real brasileño");
            System.out.println("4) Real brasileño => Dolar ");
            System.out.println("5) Dolar => Peso colombiano");
            System.out.println("6) Peso colombiano => Dolar ");
            System.out.println("7) Dolar => Peso Mexicano");
            System.out.println("8) Peso Mexicano => Dolar ");
            System.out.println("9) Salir");
            System.out.println("Elija una opcion valida.");
            System.out.println("********************************");
            choice = sc.nextInt();
            switch (choice) {
                case 1, 2, 3, 4, 5, 6, 7, 8:
                    try {
                        String firstCurrency = getFirstCurrency(choice);
                        String currencyToCompare = getCurrencyToCompare(choice);
                        Currency currency = apiCall.getCurrency(firstCurrency);
                        System.out.print(String.format("Ingrese el valor de %s que deseas convertir a %s", firstCurrency, currencyToCompare));
                        double quantity = sc.nextDouble();
                        System.out.println("Conversion: ");
                        System.out.println(String.format("El valor de %f en %s es equivalente a %f en %s", quantity, firstCurrency, currency.getConversionRate(currencyToCompare), currencyToCompare));
                    } catch (RuntimeException e){
                        System.out.println(e.getMessage());
                        System.out.println("Finalizando API");
                        System.exit(0);
                }
                    break;
                case 9:
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida");
            }
        }
    }

    private static String getFirstCurrency(int choice) {
        switch (choice) {
            case 1, 3, 5, 7: return "USD";
            case 2: return "ARS";
            case 4: return "BRL";
            case 6: return "COP";
            case 8: return "MXN";

            default:
                throw new IllegalArgumentException("Opción de conversión no válida.");
        }
    }

    private static String getCurrencyToCompare(int choice) {
        switch (choice) {
            case 2, 4, 6, 8: return "USD";
            case 1: return "ARS";
            case 3: return "BRL";
            case 5: return "COP";
            case 7: return "MXN";

            default:
                throw new IllegalArgumentException("Opción de conversión no válida.");
        }
    }
}
