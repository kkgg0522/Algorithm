import java.util.Scanner;
import java.util.Stack;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int repeat_count = sc.nextInt();
        int sum = 0;
        for (int i = 0; i < repeat_count; i++) {
            int n = sc.nextInt();
            if (!numIsZero(n)) {
                stack.pop();
            } else {
                stack.push(n); //0이 아니면 push
            }
        }

        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        System.out.println(sum);

    }

    static boolean numIsZero(int n){
        if(n==0){
           return false;
        }
        return true;
    }
}