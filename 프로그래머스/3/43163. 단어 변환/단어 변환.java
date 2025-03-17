import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        if (!wordSet.contains(target)) return 0;
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(begin, 0));
        Set<String> visited = new HashSet<>();
        
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            String word = current.word;
            int steps = current.steps;
            
            if (word.equals(target)) return steps;
            
            for (String nextWord : wordSet) {
                if (!visited.contains(nextWord) && isOneLetterDiff(word, nextWord)) {
                    visited.add(nextWord);
                    queue.add(new Pair(nextWord, steps + 1));
                }
            }
        }
        
        return 0;
    }
    
    private boolean isOneLetterDiff(String word1, String word2) {
        int count = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) count++;
            if (count > 1) return false;
        }
        return count == 1;
    }
    
    static class Pair {
        String word;
        int steps;
        
        Pair(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }
    }
    
}