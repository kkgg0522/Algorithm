import java.io.*;

public class Main {
    static int zero_count;
    static int one_count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int repeat_count = Integer.parseInt(br.readLine());
        int[] zero = new int[41];
        int[] one = new int[41];
        zero[0]++;
        one[1]++;
        for (int i = 2; i < zero.length; i++) {
            zero[i] = zero[i - 1] + zero[i - 2];
            one[i] = one[i - 1] + one[i - 2];
        }
        for (int i = 0; i < repeat_count; i++) {
            zero_count=0;
            one_count=0;
            int n=Integer.parseInt(br.readLine());
            bw.write(zero[n]+" "+one[n]+"\n");
        }
        bw.flush();
    }
}