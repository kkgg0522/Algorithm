import java.util.*;

class Solution {
    public int solution(String s) {
        String[] arr = s.split(" ");
        
        int sum = 0;
        
        Stack<String> stack = new Stack<>();
        
        for(int i=0; i<arr.length; i++){
            stack.push(arr[i]);
        }
        
        while(!stack.isEmpty()){
            String pop = stack.pop();
            
            if(pop.equals("Z")){
                stack.pop();
            }else{
                sum += Integer.parseInt(pop);
            }
        }
        
        return sum;
    }
}