package circularprime;
import java.math.BigInteger;
import java.util.Scanner;


public class CircularPrime {

    public static void main(String args[]) {
        
    }
        
    public Boolean esPrimo(BigInteger bi){ //Comprobador de primalidad con probabilidad
        Boolean b2, b3;
        b2 = bi.isProbablePrime(1);
        b3 = bi.isProbablePrime(-1);
        if (b2 & b3) {
           return true;
        } 
        return false;
    }
}
