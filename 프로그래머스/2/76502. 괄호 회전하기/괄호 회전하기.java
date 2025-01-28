import java.util.*;

class Solution {
    private static char[] change(char[] chars){
        char tmp = chars[0];

        for (int i=1; i<chars.length; i++){
            chars[i-1] = chars[i];
        }
        
        chars[chars.length-1] = tmp;
        return chars;
    }
    
    private static char closed(char s){
        switch (s) {
            case ']':
                return '[';
            case ')':
                return '(';
            case '}':
                return '{';
            default:
                return 'x';
        }
    }
    
    private static boolean vali(char[] s){
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length; i++){
            switch (s[i]) {
                case '(', '[', '{':
                    stack.push(s[i]);
                    break;
                case ')', ']', '}':
                    char closed = closed(s[i]);

                    if(!stack.isEmpty()){
                        char vali = stack.pop();
                        if(closed != vali) {
                            return false;
                        }
                    }else{
                        return false;
                    }
                    break;
                default:
                    return false;
            }
        }
        return stack.isEmpty();
    }
    public int solution(String s) {
        int answer = 0;

        char[] chars = s.toCharArray();
        for(int i=0; i<chars.length-1; i++) {
            if(vali(chars)){
                answer++;
            }
            chars = change(chars);
        }
        return answer;
    }
}