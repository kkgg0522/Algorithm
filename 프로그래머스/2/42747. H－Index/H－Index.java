import java.util.Arrays;
 
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int total = citations.length;
 
        Arrays.sort(citations);
 
        for(int i = 0 ; i < total ; i++) {
            int h_index = total - i;
            if(citations[i] >= h_index) {
                answer = h_index;
                break;
            }
        }
 
        return answer;
    }
}