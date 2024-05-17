import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int repeat_count = sc.nextInt();
        int a,b;
        int[][] apart = new int[15][15];

        for (int i = 0; i < 15; i++) {
            apart[0][i]=i+1;
        }
        for (int i = 0; i < repeat_count; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            for (int j = 1; j <= a; j++) { //해당 층수만큼만
                for (int k = 0; k <= b; k++) { //해당 호수만큼만
                    if (k == 0) {
                        apart[j][k] = 1;
                        continue;
                    }
                    apart[j][k] = apart[j - 1][k] + apart[j][k - 1];
                }

            }
            System.out.println(apart[a][b-1]);
        }

    }
}