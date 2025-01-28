import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Deque<Integer> q = new ArrayDeque<>();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            q.add(progresses[i]);
        }


        int count;
        int i=0;
        int sumDay = 0;
        while(!q.isEmpty()){
            Integer poll = q.poll();
            if(poll < 100) {
                int pollDay = (int) (Math.ceil((100.0 - poll) / speeds[i % progresses.length]));
                sumDay += pollDay;
            }
            count = 1;

            while(!q.isEmpty()){
                Integer sub = q.poll();
                i++;
                sub += speeds[i%progresses.length] * sumDay;
                if(sub >=100){
                    count++;
                }else{
                    q.addFirst(sub);
                    break;
                }
            }
            list.add(count);
        }


        int[] array = list.stream().mapToInt(Integer::intValue).toArray();

        return array;
    }
}