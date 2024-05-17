import java.io.*;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedHashMap<String, Integer> ownMap = new LinkedHashMap<>();
        int repeat_count = Integer.parseInt(br.readLine());
        String[] tempStrings=br.readLine().trim().split(" ");

        for (int i = 0; i < repeat_count; i++) {
            if(!ownMap.containsKey(tempStrings[i])){
                ownMap.put(tempStrings[i],1);
            }else {
                ownMap.put(tempStrings[i],ownMap.get(tempStrings[i])+1);
            }
        }

        repeat_count = Integer.parseInt(br.readLine());
        tempStrings=br.readLine().trim().split(" ");

        int[] count = new int[repeat_count];
        for (int i = 0; i < repeat_count; i++) {
            if(ownMap.containsKey(tempStrings[i])){
                count[i]=ownMap.get(tempStrings[i]);
            }else {
                count[i]=0;
            }
            bw.write(count[i] + " ");
        }
        bw.flush();
    }
}
