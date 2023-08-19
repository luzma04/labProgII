import java.util.Scanner;

public class Division_resta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dividendo, divisor, cociente = 0;

        System.out.println("- - - DIVISIÓN CON RESTA - - -");
        System.out.print("Ingrese el dividendo: ");
        dividendo = scanner.nextInt();
        System.out.print("Ingrese el divisor: ");
        divisor = scanner.nextInt();

        System.out.println("- - - ITERATIVO - - -");
        System.out.println("El resultado de la división es: " + divisionresta(dividendo, divisor, cociente));

        System.out.println("- - - RECURSIVIDAD - - -");
        System.out.println("El resultado de la división es: " + divisionresta(dividendo, divisor));
    }

    public static int divisionresta(int dividendo, int divisor, int cociente) {

        while (dividendo >= divisor) {
            dividendo -= divisor;
            cociente++;
        }
        return cociente;
    }

    public static int divisionresta(int dividendo, int divisor) {
        if (dividendo < divisor) {
            return 0;
        }
        return 1 + divisionresta(dividendo - divisor, divisor);
    }
}
