import java.util.*;
class Solution {
    class CacheData{
        String data;
        int turn;
        
        public CacheData(String data, int turn){
            this.data = data;
            this.turn = turn;
        }
    }
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if(cacheSize <= 0){
            return cities.length * 5;
        }
        
        List<CacheData> cache = new ArrayList<>();

        for(int i=0; i<cities.length; i++){    
            int cacheIndex = indexOf(cache, cities[i].toLowerCase());
            if(cacheIndex > -1){
                answer += 1;
                cache.get(cacheIndex).turn = i;
                continue;
            }
            
            answer += 5;
            CacheData data = new CacheData(cities[i].toLowerCase(),i);
            
            if(cache.size() < cacheSize){
                cache.add(data);
                continue;
            }
            
            cache.sort((o1,o2) -> Integer.compare(o1.turn, o2.turn));
            if(cache.size() > 0){
                cache.remove(0);
                                
            }
            cache.add(data);
        }
        
        
        return answer;
    }
    
    private int indexOf(List<CacheData> list, String target){
        int index = -1;
        for(CacheData cd : list){
            index++;
            if(target.equals(cd.data)){
                return index;
            }
        }
        
        return -1;
    }
}