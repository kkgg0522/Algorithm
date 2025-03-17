import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
         PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // 배열의 요소를 최대 힙에 삽입
        for (int work : works) {
            maxHeap.add(work);
        }

        while (n > 0 && !maxHeap.isEmpty()) {
            int max = maxHeap.poll(); 
            if (max == 0) break; 
            maxHeap.add(max - 1);
            n--;
        }

        long answer = 0;
        while (!maxHeap.isEmpty()) {
            int work = maxHeap.poll();
            answer += (long) work * work;
        }

        return answer;
    }
}