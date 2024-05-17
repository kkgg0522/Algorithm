import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = br.readLine();
            if (s.equals("0")) break;

            char[] arr = s.toCharArray();
            StringBuilder sb = new StringBuilder("");
            for (int i = arr.length-1; i >= 0; i--) {
                sb.append(arr[i]);
            }

            if (s.equals(sb.toString())){
                System.out.println("yes");
            } else System.out.println("no");
        }
    }
}