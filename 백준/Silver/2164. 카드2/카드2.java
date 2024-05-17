import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static Queue<Integer> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int repeat_count = Integer.parseInt(br.readLine());
         queue = new LinkedList<>();

        for (int i = 1; i <=repeat_count; i++) {
            queue.add(i);
        }
        if(queue.size()>=3) {
            int last = pollQueue();
            if (last == -1) {
                System.out.println("?");
            }else{
                System.out.println(last);
            }
        } else if(queue.size()==2) {
            queue.poll();
            System.out.println(queue.poll());
        } else{
            System.out.println(queue.poll());
        }
    }

    static int pollQueue(){
        int temp;
        while(queue.size()>2){
            queue.poll();
            temp = queue.poll();
            queue.add(temp);
        }
        queue.poll();
        return queue.poll();

    }
}


