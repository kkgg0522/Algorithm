import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int repeat = Integer.parseInt(br.readLine());

        if (repeat%10 == 0) {
            int five = repeat / 300;
            int one = repeat % 300 / 60;
            int sec = repeat % 300 % 60 / 10;

            bw.write(five + " " + one + " " + sec + "\n");
        } else {
            bw.write("-1");
        }

        bw.flush();

    }
}

