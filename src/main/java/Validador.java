import java.util.Scanner;

public class Validador {

    public static String entradaString() {

        Scanner teclado = new Scanner(System.in);
        return teclado.nextLine();
    }

    public static double entradaDouble() {

        double entrada = 0;

        try {
            entrada = Double.parseDouble(entradaString());
        } catch (NumberFormatException ex) {
            System.out.println("Entrada no válida");
        }
        return entrada;
    }
    public static int entradaInt() {

        int entrada = 0;

        try {
            entrada = Integer.parseInt(entradaString());
        } catch (NumberFormatException ex) {
            System.out.println("Entrada no válida");
        }
        return entrada;
    }
    public static int entradaOpcion() {

        String entrada;

        entrada = entradaString();
        if (entrada.equals("Sí")) {
            return 1;
        }
        return 0;
    }
}
