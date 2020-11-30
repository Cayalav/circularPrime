package circularprime;
import java.math.BigInteger;
import java.util.Scanner;


public class CircularPrime {

    public static void main(String args[]) {
        
        int primesSize = 1000000; // Declaramos nuestro numero limite para limitar el conjunto
        int[] primeNumbers = new int[primesSize];
        for (int i = 0; i < primesSize; i++) { //Generación de numeros primos con optimo comprobador
            if (esPrimo(BigInteger.valueOf(i))) {
                primeNumbers[i] = i;
                System.out.println(i);
            }
        }
    }
        
    public static Boolean esPrimo(BigInteger bi){ //Comprobador de primalidad con probabilidad
        Boolean b2, b3;
        b2 = bi.isProbablePrime(1);
        b3 = bi.isProbablePrime(-1);
        if (b2 & b3) {
           return true;
        } 
        return false;
    }
}
