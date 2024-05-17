import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    static HashSet<Integer> set = new HashSet<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int repeat_count = sc.nextInt();

        for (int i = 0; i < repeat_count; i++) {
            set.add(sc.nextInt());
        }

        repeat_count = sc.nextInt();
        for (int i = 0; i < repeat_count; i++) {
            setBw(sc.nextInt());
        }
        bw.flush();
    }

    static void setBw(int x) throws IOException {
        if(set.contains(x)){
            bw.write("1\n");
        }else {
            bw.write("0\n");
        }
    }
}
