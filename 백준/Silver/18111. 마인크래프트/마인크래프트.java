import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class MineCraft implements Comparable<MineCraft> {
        private int time;
        private int Y;
        MineCraft(int time, int y){
            this.time=time;
            this.Y=y;
        }

        public int getTime() {
            return time;
        }

        public int getY() {
            return Y;
        }

        @Override
        public int compareTo(MineCraft o) {
            if(this.time==o.time){
                return o.Y-this.Y;
            }
            return this.time-o.time;
        }
    }
    static int B;
    static int num;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        int sum=0;
        int max=0;
        int min=256;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                sum+=arr[i][j];
                if(max<arr[i][j])
                    max=arr[i][j];
                if(min>arr[i][j])
                    min=arr[i][j];
            }
        }
        num = Math.round((float) sum/(N*M)-1);

        ArrayList<MineCraft> list = new ArrayList<>();
        MineCraft mi;

        for (int i = 0; i < max+30; i++) {
            if(i <=256) {
                mi=install_Break(i);
                if(mi!=null)
                    list.add(mi);
            }else{ break; }
        }


        Collections.sort(list);
        mi = list.get(0);
        System.out.println(mi.getTime()+" "+mi.getY()   );
    }

    static MineCraft install_Break(int num){
        int tempB=B;
        int installBlock=0;
        int breakBlock=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i][j]< num){
                    installBlock+= num -arr[i][j];
                }else if(arr[i][j]> num){
                    breakBlock+=((arr[i][j]- num)*2);
                    tempB+=(arr[i][j]- num);
                }
            }
        }
        if(installBlock<=tempB){
            return new MineCraft(installBlock+breakBlock, num);
        }else{
            return null;
        }
    }
}