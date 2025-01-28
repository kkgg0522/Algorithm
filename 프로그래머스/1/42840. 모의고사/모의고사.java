import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int ansLength = answers.length;
        int[] sCount = new int[3];
        int[] typeA=new int[]{1,2,3,4,5};
        int[] typeB=new int[]{2,1,2,3,2,4,2,5};
        int[] typeC=new int[]{3,3,1,1,2,2,4,4,5,5};
        List<Integer> list = new ArrayList<>(); 
        
        for(int i=0; i<ansLength; i++){
            if(typeA[i%typeA.length]==answers[i]){
                sCount[0]++;
            }
            if(typeB[i%typeB.length]==answers[i]){
                sCount[1]++;
            }
            if(typeC[i%typeC.length]==answers[i]){
                sCount[2]++;
            }
        }
        int max=Arrays.stream(sCount)
                        .max()
                        .orElse(0);
        for(int i=0;i<sCount.length;i++){
            if(sCount[i]==max){
                list.add(i+1);
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}