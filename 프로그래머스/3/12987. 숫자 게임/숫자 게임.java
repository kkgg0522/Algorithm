import java.util.*;

class Solution {
     public static int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int aIndex = 0;
        int bIndex = 0;

        while (bIndex < B.length) {
            if (B[bIndex] > A[aIndex]){
                answer++;
                aIndex++;
            }
            bIndex++;
        }

        return answer;
    }

}