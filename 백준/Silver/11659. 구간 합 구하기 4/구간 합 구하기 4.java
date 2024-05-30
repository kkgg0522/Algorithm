import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer> list;
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int number_count=Integer.parseInt(st.nextToken());
        int repeat_count=Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        array = new int[number_count+1];
        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < number_count; i++) {
            int number = Integer.parseInt(st.nextToken());
            list.add(number);
            array[i+1] = array[i] + number;
        }

        for (int i = 0; i < repeat_count; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int sum = 0;
            int n = Integer.parseInt(st.nextToken())-1;
            int m = Integer.parseInt(st.nextToken());
            if (n == m) {
                bw.write(list.get(n) + "\n");
                break;
            }

            bw.write(array[m] - array[n] +"\n");

        }

        bw.flush();
    }

}

