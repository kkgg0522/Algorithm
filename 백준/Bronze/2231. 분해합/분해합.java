    import java.io.*;
    import java.util.ArrayList;

    public class Main {
        static int num;
        static int calc_num(){
            for (int i = 1; i < num; i++) {
                 if(num==i+split_num(i)){
                     return i;
                 };
            }
            return 0;
        }

        static int split_num(int n){
            ArrayList<Integer> arr = new ArrayList<>();
            int ten=10;
            while (n > 0) {
                arr.add(n % ten);
                n /= ten;
            }

            int sum=0;
            for (int x : arr) {
                sum+=x;
            }
            return sum;
        }



        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            num = Integer.parseInt(br.readLine());
            int m=0;
            m=calc_num();
            System.out.println(m);
        }
    }
