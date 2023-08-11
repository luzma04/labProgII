import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        int n1, n2, n3;
        System.out.println("Ingrese el primer número: ");
        n1 = t.nextInt();
        System.out.println("Ingrese el segundo número: ");
        n2 = t.nextInt();
        System.out.println("Ingrese el tercer número: ");
        n3 = t.nextInt();

        int mayor = (n1>n2)?n1:n2;
        mayor = (mayor<n3)?n3:mayor;
        int menor = n1;
        menor = (n2<menor)?n2:menor;
        menor = (n3<menor)?n3:menor;

        int medio = (n1+n2+n3) - mayor - menor;

        System.out.println("El número mayor es: " + mayor);
        System.out.println("El número del medio es: " + medio);
        System.out.println("El número menor es: " + menor);
    }
}
