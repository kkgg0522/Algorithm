import java.util.*;
 
class Solution {
    public int solution(int[][] board, int[] moves) {
         int answer = 0;

        Stack<Integer>[] stack = new Stack[board.length+1];
        stack[board.length] = new Stack<Integer>();

        for(int i=0;i<board[0].length; i++){
            stack[i] = new Stack<Integer>();
            for (int j=board.length-1; j>=0; j--){
                if(board[j][i]==0)
                    continue;
                stack[i].push(board[j][i]);
            }
        }

        for(int i=0; i<moves.length; i++){
            if(!stack[moves[i]-1].isEmpty()){
                Integer doll = stack[moves[i]-1].pop();
                if(!stack[board.length].isEmpty()){
                    if(stack[board.length].peek() == doll){
                        answer+=2;
                        stack[board.length].pop();
                    }else{
                        stack[board.length].push(doll);
                    }
                }else{
                    stack[board.length].push(doll);
                }

            }

        }


        return answer;
    }
}