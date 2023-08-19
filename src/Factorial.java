import java.util.Scanner;
public class Factorial {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        int x, i;
        i=0;
        System.out.println("- - - FACTORIAL - - -");
        System.out.println("Ingrese un num: ");
        x = t.nextInt();
        System.out.println("- - - ITERATIVO - - - ");
        System.out.println("El resultado del factorial es: "+factorial(x,i));
        System.out.println("- - - RECURSIVIDAD - - - ");
        System.out.println("El resultsdo del factorial es: "+factorial(x));
    }

    public static int factorial(int x, int i){
        for(i=x-1;i>=1;i--){
            x=x*i;
        }
        return x;
    }

    public static int factorial(int x){
        int aux;
        aux=x;
        if (aux<=1){
            return 1;
        }
        return (x * factorial(aux-1));
    }
}