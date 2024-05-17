    import java.io.*;

    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int repeat_count = Integer.parseInt(br.readLine());
            int[] array = new int[10001];
            for (int i = 0; i < repeat_count; i++) {
                array[Integer.parseInt(br.readLine())]++;
            }

            for (int i = 1; i <= 10000; i++) {
                if (array[i] != 0) {
                    for (int j = 0; j < array[i]; j++) {
                        bw.write(i + "\n");
                    }
                }
            }
            bw.flush();
        }
    }
