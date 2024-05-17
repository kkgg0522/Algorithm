import java.io.*;

public class Main {
    static boolean[] arr;
    static int n;

    public static void listRemove() {
        // true = 소수아님 , false = 소수
        arr[0] = arr[1] = true;

        for (int i = 2; i <= Math.sqrt(arr.length); i++) {
            if (arr[i]) continue;
            for (int j = i * i; j < arr.length; j += i) {
                arr[j] = true;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] temp = br.readLine().trim().split(" ");
        int m = Integer.parseInt(temp[0]);
        n = Integer.parseInt(temp[1]);

        arr=new boolean[n+1];

        for (int i = 0; i < 2; i++) {
            arr[i]=true;
        }

        listRemove();

        for (int i = m; i <= n; i++) {
            if(!arr[i]) bw.write(i+"\n");
        }

        bw.flush();
    }
}
