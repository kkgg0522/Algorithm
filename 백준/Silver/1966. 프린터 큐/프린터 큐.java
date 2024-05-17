import java.io.*;
import java.util.ArrayList;

public class Main {
    static boolean status;
    static ArrayList<PRINTER> queue;
    static int print(PRINTER search_pri){
        PRINTER empty= new PRINTER();
        PRINTER remove = empty;
        int count = 0;
        while(!remove.equals(search_pri)) {
            if(big_search()) {
                remove = queue.remove(0);
                queue.add(remove);
                remove = empty;
            }else{
                remove = queue.remove(0);
                count++;
            }
        }
        return count;
    }

    static boolean big_search(){
        for (PRINTER printer : queue)
            if (queue.get(0).getImportance() < printer.getImportance())
                return true;
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int repeat_count = Integer.parseInt(br.readLine());
        int queue_len;
        int search_idx;
        int[] ints;


        for (int i = 0; i < repeat_count; i++) {
            ints = InputToInt(br.readLine().trim().split(" "));
            queue_len = ints[0];
            search_idx = ints[1];
            ints = InputToInt(br.readLine().trim().split(" "));
            queue = new ArrayList<>();
            for (int j = 0; j < queue_len; j++) {
                queue.add(new PRINTER(ints[j]));
            }
            int count = print(queue.get(search_idx));

            System.out.println(count);
        }
    }

    static int[] InputToInt(String[] s){
        int[] n = new int[s.length];
        for (int i = 0; i < n.length; i++) {
            n[i] = Integer.parseInt(s[i]);
        }
        return n;
    }

    static class PRINTER{
        private final int importance;

        public PRINTER() {
            this(0);
        }

        public PRINTER(int importance) {
            this.importance = importance;
        }

        public int getImportance() {
            return importance;
        }
    }
}


