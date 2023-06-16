import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        Set<Integer> rSet = new HashSet<>();
        Arrays.sort(lost);
        for (int r : reserve) {
            rSet.add(r);
        }
        for (int i=0; i<lost.length; i++) {
            if (rSet.contains(lost[i])) {
                rSet.remove(lost[i]);
                lost[i] = 0;
                answer++;
            }         
        }
        for (int i=0; i<lost.length; i++) {
            if (lost[i] == 0) continue;
            if (rSet.contains(lost[i]-1)) {
                rSet.remove(lost[i]-1);
                answer++;
            } else if (rSet.contains(lost[i]+1)) {
                rSet.remove(lost[i]+1);
                answer++;
            }
        }
        return answer;
    }
}