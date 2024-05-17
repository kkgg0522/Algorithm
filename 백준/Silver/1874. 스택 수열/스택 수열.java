import java.io.*;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class Main {
    static Character push_msg(){
        return '+';
    }
    static Character pop_msg(){
        return '-';
    }
    static Stack<Integer> stack = new Stack<>();
    static int start=1;
    static ArrayList<Integer> list = new ArrayList<>();
//    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean stack_status = true;
    static ArrayList<Character> chars = new ArrayList<>();
    static void stack_method(int n) throws IOException {
        try {
            if (!stack.contains(n)) {
                for (int i = start; i <= n; i++) {
                    stack.push(i);
                    chars.add(push_msg());
                }
                start = n + 1;
                list.add(stack.pop());
                chars.add(pop_msg());
            } else {
                while (!stack.peek().equals(n)) {
                    list.add(stack.pop());
                    chars.add(pop_msg());
                }
                list.add(stack.pop());
                chars.add(pop_msg());
            }
        }catch (EmptyStackException e) {
            stack_status = false;
            print_NO();
        }
    }
    static void print_NO() throws IOException {
//        bw=new BufferedWriter(new OutputStreamWriter(System.out));
//        bw.write("NO");
//        bw.flush();
//        bw.close();
        System.out.println("NO");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int repeat_count = Integer.parseInt(br.readLine());

        ArrayList<Integer> standard_list = new ArrayList<>();
        for (int i = 0; i < repeat_count; i++) {
            standard_list.add(Integer.parseInt(br.readLine()));
            stack_method(standard_list.get(i));
        }

        if(list.equals(standard_list)&&stack_status){
            for(char s : chars)
                System.out.println(s);
        }
    }
} 
