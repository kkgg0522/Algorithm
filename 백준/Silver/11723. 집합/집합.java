
import java.io.*;
import java.util.*;

public class Main {
    static LinkedHashSet<Integer> set;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        set = new LinkedHashSet<>();
        int repeat_count=Integer.parseInt(br.readLine());

        for (int i = 0; i < repeat_count; i++) {
            String temp = br.readLine().trim();
            if(temp.equals("all")){
                set = new LinkedHashSet<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
            } else if(temp.equals("empty")){
                set = new LinkedHashSet<>();
            } else{
                Controller(temp);
            }
        }
        bw.flush();
    }
    static void Controller(String temp) throws IOException {
        String[] split_Arr = temp.split(" ");
        String con = split_Arr[0];
        int val = Integer.parseInt(split_Arr[1]);
        if(con.equals("toggle")){
            if(set.contains(val)){
                con="remove";
            }else{
                con="add";
            }
        }
        if(con.equals("add"))
            set.add(val);
        else if (con.equals("remove")){
            set.remove(val);
        }else if (con.equals("check")){
            if(set.contains(val)){
                bw.write("1\n");
            } else{
                bw.write("0\n");
            }
        }
    }
}
