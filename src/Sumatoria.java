import java.util.Scanner;
public class Sumatoria {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        int x, i;
        i=0;
        System.out.println("- - - SUMATORIAS - - -");
        System.out.println("Ingrese un num: ");
        x = t.nextInt();
        System.out.println("- - - ITERATIVO - - - ");
        System.out.println("El resultsdo de las sumas es: "+sumar(x,i));
        System.out.println("- - - RECURSIVIDAD - - - ");
        System.out.println("El resultsdo de las sumas es: "+sumar(x));
    }

    public static int sumar(int x, int i){
        for(i=x-1;i>=0;i--){
            x=x+i;
        }
        return x;
    }

    public static int sumar(int x){
        int aux;
        aux=x;
        if (aux<=0){
            return 0;
        }
        return x + sumar(aux-1);
    }
}