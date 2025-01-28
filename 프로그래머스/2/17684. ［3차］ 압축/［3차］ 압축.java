import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put(String.valueOf((char) (i + 'A')), i + 1);
        }

        List<Integer> list = new ArrayList<>();
        int idx = 27; 
        int i = 0; 

        while (i < msg.length()) {
            int j = i + 1;

            while (j <= msg.length() && map.containsKey(msg.substring(i, j))) {
                j++;
            }

            list.add(map.get(msg.substring(i, j - 1)));

            if (j <= msg.length()) {
                map.put(msg.substring(i, j), idx++);
            }

            i = j - 1;
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

 
}
