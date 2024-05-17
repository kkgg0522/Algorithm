    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.Stack;

    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int repeat_count = Integer.parseInt(br.readLine());
            char[] chars;
            Stack<Character> stack;
            boolean stack_status;
            for (int i = 0; i < repeat_count; i++) {
                stack = new Stack<>();
                String temp = br.readLine().trim();
                chars = temp.toCharArray();
                stack_status = true;

                for (int j = 0; j < chars.length; j++) {
                    if(chars[j] == '(') {
                        stack.push(chars[j]);
                    }
                    else if(chars[j] == ')') {
                        if(!stack.isEmpty() && stack.peek() == '('){
                            stack.pop();
                        }else{
                            stack_status = false;
                        }
                    }
                }
                if(stack.isEmpty() && stack_status) {
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
                stack.clear();
            }
        }
    }
