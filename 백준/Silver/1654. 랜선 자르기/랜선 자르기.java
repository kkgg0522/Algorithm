import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[] arrays;
    static long key;

static long Binary_Search(long start, long end){
    if (start > end) return -1; 

    long mid = (start + end) / 2;
    long total = 0;
    for (long x : arrays) {
        total += x / mid;
    }

    if (total >= key) {
        return Math.max(mid, Binary_Search(mid + 1, end));
    } else {
        return Binary_Search(start, mid - 1);
    }
}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] k_n = stringsToInts(br.readLine().split(" "));
        arrays = new long[(int)k_n[0]];
        key = k_n[1];
        long sum=0;
        long max=0;
        for (int i = 0; i < arrays.length; i++) {
            arrays[i]=Long.parseLong(br.readLine());
            sum+= arrays[i];
            if(arrays[i]>max){
                max=arrays[i];
            }
        }

        System.out.println(Binary_Search(1,max));
    }

    static long[] stringsToInts(String[] s){
        long[] longs = new long[s.length];
        for(int i = 0; i < s.length; i++){
            longs[i] = Integer.parseInt(s[i]);
        }
        return longs;
    }
}