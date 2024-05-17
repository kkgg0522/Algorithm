import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Long,String> map1 = new HashMap<>();
        HashMap<String,Long> map2 = new HashMap<>();
        long sequence=0L;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            map1.put(++sequence, s);
            map2.put(s,sequence);
        }
        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            char c = s.charAt(0);
            if(Character.isDigit(c)){
                bw.write(map1.get(Long.parseLong(s))+"\n");
            }else{
                bw.write(map2.get(s)+"\n");
            }
        }
        bw.flush();
    }
}
