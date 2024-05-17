import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int repeat_count = Integer.parseInt(br.readLine());

        Map<String,Integer> map;
        for (int i = 0; i < repeat_count; i++) {
            int put_on = Integer.parseInt(br.readLine());
            map = new HashMap<>();
            for (int j = 0; j < put_on; j++) {
                st = new StringTokenizer(br.readLine()," ");
                st.nextToken();
                String o = st.nextToken();
                map.put(o, map.getOrDefault(o,0)+1);
            }
            int sum = 1;
            for (Integer x : map.values()) {
                sum *= x+1;
            }
            bw.write(sum-1+"\n");
        }
        bw.flush();
    }
}