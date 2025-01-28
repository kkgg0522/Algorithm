import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        int[] count = new int[N+2];
        double total = stages.length;
        for(int i=0; i<(int)total; i++){
            count[stages[i]]++;
        }
        
        
        HashMap<Integer,Double> fails = new HashMap<>();
        
        for(int i=1; i<=N; i++){
            if(count[i]==0){
                fails.put(i,0.);
            }else{
                fails.put(i, count[i]/total);
                total -= count[i];
            }
        }
        
        answer = fails.entrySet().stream().sorted((o1,o2) -> Double.compare(o2.getValue(),o1.getValue())).
            mapToInt(HashMap.Entry::getKey).toArray();
        return answer;
    }
}