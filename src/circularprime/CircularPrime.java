package circularprime;

import java.math.BigInteger;
import java.util.Scanner;

public class CircularPrime {

    public static void main(String args[]) {
        int contPrimeCircular = 0;

        int primesSize = 1000000; // Declaramos nuestro numero limite para limitar el conjunto
        int[] primeNumbers = new int[primesSize];
        for (int i = 0; i < primesSize; i++) { //Generación de numeros primos con optimo comprobador
            if (esPrimo(BigInteger.valueOf(i))) {
                     
                if (esCircular(i)) { // Como la pregunta es cuantos numeros primos circular hay por debajo del 1.000.000
                 // Vamos a sumar un contador que nos va a dar esta cuenta   
                 contPrimeCircular++;
                }
            }

        }
        System.out.println("Cantidad de numeros primos circulares por debajo de: "+primesSize);
        // Este valor peude fluctuar levemente en ocasiones debido a que 
        // isProbablePrime es bastante optimo pero carece de precisión al basarse
        // en probabilidad
        System.out.println(contPrimeCircular);  
    }

    public static Boolean esCircular(int primeNum) { // Esta función nos va a comprobar cada permutación a nivel individual
        // Si y solo si todas las permutaciones son verdaderas ( o primas ), entonces
        // vamos a tener que es un numero primo circular
        int num = primeNum;
        int n = String.valueOf(primeNum).length();
        boolean isCircularPrime = true;

        while (true) {

            if ((!esPrimo(BigInteger.valueOf(num)))) {
                isCircularPrime = false;
            }
            int rem = num % 10;
            int dev = num / 10;
            num = (int) ((Math.pow(10, n - 1)) // Permutamos 
                    * rem + dev);
            if (num == primeNum) {
                break;
            }
        }
        return isCircularPrime;
    }

    public static Boolean esPrimo(BigInteger bi) { //Comprobador de primalidad con probabilidad
        Boolean b2, b3;
        b2 = bi.isProbablePrime(1);
        b3 = bi.isProbablePrime(-1);
        if (b2 & b3) {
            return true;
        }
        return false;
    }
}
