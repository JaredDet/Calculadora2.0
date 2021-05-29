public class Calculadora {

    private double num1;
    private double num2;

    public Calculadora() {
        this.num1 = 0;
        this.num2 = 0;
    }

    public double sumar(double num1, double num2) {
        return num1 + num2;
    }

    public double restar(double num1, double num2) {
        return num1 - num2;
    }

    public double multiplicar(double num1, double num2) {
        return num1 * num2;
    }

    public boolean metodoDivision(double num1, double num2) {

        if (num2 != 0) {
            return true;
        }
        System.err.print("No se puede dividir por cero" + "\n");
        System.out.println();
        return false;
    }

    private double dividir(double num1, double num2) {
        return num1 / num2;
    }

    public double potencia(double num1, double num2) {
        return Math.pow(num1, num2);
    }

    private double raiz(double num1, double num2) {
        return Math.pow(num1, 1.0 / num2);
    }

    public boolean metodoRaiz(double num1, double num2) {
        if (num2 != 0) {
            return true;
        }
        System.err.print("No se puede dividir por cero" + "\n");
        System.out.println();
        return false;
    }

    private double logaritmo(double num1, double num2) {

        return Math.log10(num1) / Math.log10(num2);
    }

    public boolean metodoLogaritmo(double num1, double num2) {

        if (num1 > 0 && num2 > 0) {
            return true;
        }
        System.err.print("El logaritmo no está definido para los no naturales" + "\n");
        System.out.println();
        return false;
    }

    private void mostrarMenu() {

        System.out.println("""

                Bienvenido al menú
                """);
        System.out.println("Elija una opción" + "\n");
        System.out.println("[1] Sumar");
        System.out.println("[2] Restar");
        System.out.println("[3] Multiplicar");
        System.out.println("[4] Dividir");
        System.out.println("[5] Calcular exponente");
        System.out.println("[6] Calcular raíz");
        System.out.println("[7] Calcular logaritmo");
        System.out.println("[8] Salir" + "\n");
    }

    private void cargarValor(Archivo archivo) {

        num1 = Double.parseDouble(archivo.cargarArchivo().get(0));
        System.out.println("Se ha cargado el número: " + num1);
    }

    private double pedirNumero() {

        System.out.println("Escriba el valor del número");
        return Validador.entradaDouble();
    }

    public void menu() {
        Archivo archivo = new Archivo();
        int opcion;
        System.out.println("Escriba Sí si desea utilizar el último valor guardado");

        opcion = Validador.entradaOpcion();

        if (archivo.getArchivo().exists() && opcion == 1) {
            cargarValor(archivo);
        }
        double x = 0;

        do {
            mostrarMenu();
            opcion = Validador.entradaInt();

            switch (opcion) {

                case 1:
                    double num1 = this.num1;
                    if (num1 == 0) {
                        x = sumar(pedirNumero(), pedirNumero());
                    } else {
                        x = sumar(num1, pedirNumero());
                        this.num1 = 0;
                    }
                    System.out.println("La suma es: " + x);
                    break;

                case 2:
                    num1 = this.num1;
                    if (num1 == 0) {
                        x = restar(pedirNumero(), pedirNumero());
                    } else {
                        x = restar(num1, pedirNumero());
                        this.num1 = 0;
                    }
                    System.out.println("La resta es: " + x);
                    break;

                case 3:
                    num1 = this.num1;
                    if (num1 == 0) {
                        x = multiplicar(pedirNumero(), pedirNumero());
                    } else {
                        x = multiplicar(num1, pedirNumero());
                        this.num1 = 0;
                    }
                    System.out.println("La multiplicación es: " + x);
                    break;

                case 4:
                    num1 = this.num1;
                    double num2;
                    x = 0;
                    if (num1 == 0) {
                        num1 = pedirNumero();
                        num2 = pedirNumero();
                        if (metodoDivision(num1, num2)) {
                            x = dividir(num1, num2);
                        }
                    } else {
                        num2 = pedirNumero();
                        if (metodoDivision(num1, num2)) {
                            x = dividir(num1, num2);
                            this.num1 = 0;
                        }
                    }
                    System.out.println("La división es: " + x);
                    break;

                case 5:
                    num1 = this.num1;
                    if (num1 == 0) {
                        x = potencia(pedirNumero(), pedirNumero());
                    } else {
                        x = potencia(num1, pedirNumero());
                        this.num1 = 0;
                    }
                    System.out.println("La potencia es: " + x);
                    break;

                case 6:
                    x = 0;
                    num1 = this.num1;
                    if (num1 == 0) {
                        num1 = pedirNumero();
                        num2 = pedirNumero();
                        if (metodoRaiz(num1, num2)) {
                            x = raiz(num1, num2);
                        }
                    } else {
                        num2 = pedirNumero();
                        if (metodoRaiz(num1, num2)) {
                            x = raiz(num1, num2);
                            this.num1 = 0;
                        }
                    }
                    System.out.println("La raíz es: " + x);
                    break;

                case 7:
                    x = 0;
                    num1 = this.num1;
                    if (num1 == 0) {
                        num1 = pedirNumero();
                        num2 = pedirNumero();
                        if (metodoRaiz(num1, num2)) {
                            x = logaritmo(num1, num2);
                        }
                    } else {
                        num2 = pedirNumero();
                        if (metodoLogaritmo(num1, num2)) {
                            x = logaritmo(num1, num2);
                            this.num1 = 0;
                        }
                    }
                    System.out.println("El logaritmo es: " + x);
                    break;

                case 8:
                    System.out.println("Gracias por usar la calculadora");
                    System.out.println("Adiós...");
                    break;

                default:
                    System.out.println("Fallo al elegir la opción");
            }
        } while (opcion != 8);

        archivo.setValor("El valor es: " + x);
        archivo.escribirArchivo();
    }
}
