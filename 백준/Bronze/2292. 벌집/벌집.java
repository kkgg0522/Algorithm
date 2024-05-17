import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int repeat_count = Integer.parseInt(br.readLine());
        int i = 1;
        int sum = 1;
        while (repeat_count > sum) {
            sum += 6 * i;
            i++;
        }
        bw.write(String.valueOf(i));
        bw.flush();
    }
} 
