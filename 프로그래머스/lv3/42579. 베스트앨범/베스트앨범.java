import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreTotalMap = new HashMap<>();
        Map<String, Map<Integer, Integer>> genreMap = new HashMap<>();
        
        for (int i=0; i<genres.length; i++) {
            genreTotalMap.put(genres[i], genreTotalMap.getOrDefault(genres[i], 0) + plays[i]);
            Map<Integer, Integer> playMap = genreMap.getOrDefault(genres[i], new HashMap<>());
            playMap.put(i, plays[i]);
            genreMap.put(genres[i], playMap);
        }
        
        List<String> genreList = new ArrayList<>(genreTotalMap.keySet());
        genreList.sort((k1, k2) -> genreTotalMap.get(k2) - genreTotalMap.get(k1));

        List<Integer> answer = new ArrayList<>();
        for (String g : genreList) {
            Map<Integer, Integer> playMap = genreMap.get(g);
            List<Integer> playList = new ArrayList<>(playMap.keySet());
            playList.sort((k1, k2) -> playMap.get(k2) - playMap.get(k1));
            int cnt = 1;
            for (int p : playList) {
                answer.add(p);
                cnt++;
                if (cnt > 2) break;
            }
        }
        return answer.stream().mapToInt(x->x).toArray();
    }
}