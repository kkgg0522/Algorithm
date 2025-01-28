import java.util.*;
import java.util.stream.Stream;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
         //장르별 각 곡의 인덱스, 재생횟수
        HashMap<String, ArrayList<int[]>> genreMap = new HashMap<>();
        //장르별 재생 횟수
        HashMap<String, Integer> playMap = new HashMap<>();

        for(int i=0; i<genres.length; i++){
            String genre = genres[i];
            int play = plays[i];

            int[] tmp = new int[2];
            tmp[0] = i;
            tmp[1] = play;

            ArrayList<int[]> list = genreMap.getOrDefault(genre, new ArrayList<>());
            list.add(tmp);

            genreMap.put(genre, list);
            playMap.put(genre,playMap.getOrDefault(genre,0) + play);
        }

        ArrayList<Integer> answer = new ArrayList<>();

        // 장르 정렬
        Stream<Map.Entry<String, Integer>> sortedGenre = playMap.entrySet()
                .stream()
                .sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));

        // 장르를 정렬 후 최대 2곡까지 선택
        sortedGenre.forEach(entry -> {
            Stream<int[]> sortedSongs = genreMap.get(entry.getKey()).stream()
                    .sorted((o1, o2) -> Integer.compare(o2[1], o1[1]))
                    .limit(2);
            sortedSongs.forEach(song -> answer.add(song[0]));
        });

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}