/**
 ** Java Program to Implement Fermat Primality Test Algorithm
 * boolean prime = fp.isPrime(num, k); конструктор
 **/
import java.util.Scanner;
import java.util.Random;

public class FermatPrimalityTest
{
    /** Function to check if prime or not **/
    public boolean isPrime(long n, int iteration)
    {
        /** base case 1 **/
        if (n == 0) return false;

        /** base case 2 **/
        if ( n > 0 && n < 4) return true;

        /** an even number other than 2 is composite **/
        if (n % 2 == 0) return false;

        Random rand = new Random();

        for (int i = 0; i < iteration; i++)

        {
            long r = Math.abs(rand.nextLong());
            long a = r % (n - 1) + 1;
            if (modPow(a, n - 1, n) != 1) return false;
        }

        return true;
    }

    /** Function to calculate (a ^ b) % c **/
    public long modPow(long a, long b, long c)
    {
        long res = 1;

        for (int i = 0; i < b; i++)
        {
            res *= a;
            res %= c;
        }

        return res % c;
    }

    /** Main function **/
    public static void main (String[] args)

    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Fermat Primality Algorithm Test\n");

        /** Make an object of FermatPrimality class **/

        FermatPrimalityTest fp = new FermatPrimalityTest();

        /** Accept number **/

        System.out.println("Enter number\n");

        long num = scan.nextLong();

        /** Accept number of iterations **/

        System.out.println("\nEnter number of iterations");

        int k = scan.nextInt();

        /** check if prime **/

        boolean prime = fp.isPrime(num, k);

        if (prime)

            System.out.println("\n"+ num +" is prime");

        else

            System.out.println("\n"+ num +" is composite");

    }
}