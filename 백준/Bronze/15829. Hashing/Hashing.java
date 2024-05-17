import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main{
    static final long R = 31L;
    static final long M = 1234567891L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int char_num = Integer.parseInt(br.readLine());
        char[] s = new char[char_num];
        long hash = 0L;

        long r;
        for (int i = 0; i < char_num; i++) {
            r=1L;
            s[i]= (char) br.read();
            for (int j = 0; j < i; j++)
                r=(r*R)%M;
            hash = hash + ((long) (s[i] % 96) * r)%M;
        }
        System.out.println(hash%M);
    }
}