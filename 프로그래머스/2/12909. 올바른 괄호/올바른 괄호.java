import java.util.*;

class Solution {
    boolean solution(String s) {
        char[] array = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        try{
                for (char c : array) {
                    switch (c){
                    case '(':
                        stack.push(c);
                        break;
                    case ')':
                        stack.pop();
                        break;
                    }
                }
            }catch(EmptyStackException e){
                return false;
            }
            
        return stack.isEmpty();
    }
}