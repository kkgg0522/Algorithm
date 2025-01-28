import java.util.*;

class Solution {    
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String,Integer> userTable = new HashMap<>();
        Map<String,Set<String>> decl = new HashMap<>();
        
        for(int i=0; i<id_list.length; i++){
            userTable.put(id_list[i],0);
            decl.put(id_list[i], new HashSet<>());
        }
        
        for(int i=0; i<report.length; i++){
            String[] arrReport = report[i].split(" ");
            Set<String> set = decl.get(arrReport[0]);
            set.add(arrReport[1]);
            decl.put(arrReport[0], set);
        }
        
        
        for(int i=0; i<id_list.length; i++){
            Set<String> set = decl.get(id_list[i]);
            for(String s : set){
                userTable.put(s,userTable.get(s) + 1);
            }
        }
        
        for(int i=0; i<id_list.length; i++){
            Set<String> set = decl.get(id_list[i]);
            for(String s : set){
                if(userTable.get(s) >= k){
                    answer[i]++;   
                }
            }
        }
        
        return answer;
    }
}