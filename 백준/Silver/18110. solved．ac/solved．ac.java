import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int repeat_count = Integer.parseInt(br.readLine());

        if(repeat_count!=0) {
            int cutting = (int) Math.round(repeat_count * 0.15);
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < repeat_count; i++)
                list.add(Integer.parseInt(br.readLine()));

            Collections.sort(list);
            int lastIndex = repeat_count - cutting-1;

            int sum=0;
            for (int i = cutting; i <= lastIndex; i++) {
                sum+=list.get(i);
            }

            System.out.print(Math.round((double)sum / (list.size()-(cutting*2))));
        } else{
            System.out.println(0);
        }
    }
}