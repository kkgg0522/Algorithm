import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int repeat = Integer.parseInt(br.readLine());

        for (int i = 0; i < repeat; i++) {
            int num = Integer.parseInt(br.readLine());

            int quar = num/25;
            int dime = num%25/10;
            int nickel = num%25%10/5;
            int penny = num%5;

            bw.write( quar +" "+ dime +" "+ nickel+" "+ penny +"\n");
        }
        bw.flush();
    }
}

