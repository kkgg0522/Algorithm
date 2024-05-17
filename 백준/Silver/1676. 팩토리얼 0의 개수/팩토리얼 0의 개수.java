import java.io.*;
import java.math.BigInteger;

public class Main {
    static BigInteger factorial(int n){
        BigInteger fact = new BigInteger("1");
        BigInteger temp = new BigInteger(String.valueOf(n));
        if(n == 0){
            return BigInteger.valueOf(1);
        }

        while(n-- > 1){
            fact = fact.multiply(temp);
            temp = temp.subtract(BigInteger.ONE);

        }

        return fact;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String fact = String.valueOf(factorial(n));

        int zero_count = 0;
        for (int i = fact.length()-1; i >= 0; i--) {
            if(fact.charAt(i)=='0'){
                zero_count++;
            } else{
                break;
            }
        }

        System.out.print(zero_count);
    }
} 
