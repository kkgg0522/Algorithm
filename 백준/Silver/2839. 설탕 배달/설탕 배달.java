import java.io.*;

public class Main {
    static int sugar;
    static int five_count;
    static int three_count;

    static int five_div() {
        if (sugar < 5) return sugar;
        if (((sugar % 5) + 5) % 3 == 0) {
            five_count = (sugar / 5) - 1;
            return sugar % 5 + 5;
        } else if(sugar>=12 &&((sugar % 5) + 10) % 3 == 0) {
                five_count = (sugar / 5) - 2;
                return sugar % 5 + 10;
        }else{
            five_count = sugar / 5;
            return sugar % 5;
        }
    }

    static void three_count(int mod) {
        if (mod % 3 == 0) {
            three_count = mod / 3;
        } else {
            three_count = -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sugar = Integer.parseInt(br.readLine());
        int mod = five_div();
        three_count(mod);
        if (three_count != -1) {
            bw.write(three_count + five_count + "");
        } else {
            bw.write(three_count + "");
        }
        bw.flush();
    }
}
