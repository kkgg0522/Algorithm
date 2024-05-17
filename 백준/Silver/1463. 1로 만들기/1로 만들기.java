import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int num=Integer.parseInt(br.readLine());
        int[] arr = new int[10000001];

        arr[1]=0;
        arr[2]=arr[3]=1;
        int val1;
        int val2;
        int temp_val;
        for (int i = 4; i <= num; i++) {
            val1=999999999;
            if(i%3==0){
                val1=arr[i/3]+1;
            } else if (i%2==0) {
                val1=arr[i/2]+1;
            }
            if(i%3==0&&i%2==0){
                temp_val=arr[i/2]+1;
                if(val1>temp_val){
                    val1=temp_val;
                }
            }

            val2=arr[i-1]+1;

            if(val1<val2){
                arr[i]=val1;
            }else{
                arr[i]=arr[i-1]+1;
            }
        }
        bw.write(arr[num]+"");
        bw.flush();
    }
}
