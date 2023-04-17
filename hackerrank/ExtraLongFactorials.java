import java.math.*;

class ExtraLongFactorials {

    /*
     * Complete the 'extraLongFactorials' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void extraLongFactorials(int n) {
        factorial(BigInteger.valueOf(1), n);
    }

    public static void factorial(BigInteger n, int num) {
        if (num == 1) {
            System.out.println(n);
            return;
        }
        
        factorial(n.multiply(BigInteger.valueOf(num)), num - 1);
    }
}