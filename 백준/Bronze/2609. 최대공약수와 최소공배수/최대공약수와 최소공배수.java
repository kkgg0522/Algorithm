import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);

        int maxDivNumber=1;
        int i=Math.min(m,n);
        while(maxDivNumber==1 && i>1){
            if(n%i==0 && m%i==0){
                maxDivNumber = i;
            }
            i--;
        }

        int minMulNumber = 0;
        i=Math.max(m,n);
        int limit = m*n;
        while(minMulNumber==0 && i<=limit){
            if(i%n==0 && i%m==0){
                minMulNumber=i;
            }
            i++;
        }

        System.out.printf("%d\n%d",maxDivNumber,minMulNumber);
    }
}


