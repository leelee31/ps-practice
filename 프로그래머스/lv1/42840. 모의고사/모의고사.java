import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] arr = {1,2,3,4,5};
        int[] brr = {2,1,2,3,2,4,2,5};
        int[] crr = {3,3,1,1,2,2,4,4,5,5};
        int[] count = new int[3];
        int idx = 0, aIdx = 0, bIdx = 0, cIdx = 0;
        while (idx < answers.length) {           
            if (aIdx >= arr.length)
                aIdx -= 5;
            if (bIdx >= brr.length)
                bIdx -= 8;
            if (cIdx >= crr.length)
                cIdx -= 10;
            
            if (arr[aIdx] == answers[idx])
                count[0]++;
            if (brr[bIdx] == answers[idx])
                count[1]++;
            if (crr[cIdx] == answers[idx])
                count[2]++;
            
            idx++;
            aIdx++;
            bIdx++;
            cIdx++;
        }
        
        int max = Math.max(count[0], Math.max(count[1], count[2]));
        List<Integer> answer = new ArrayList<>();
        for (int i=0; i<count.length; i++) {
            if (count[i] == max)
                answer.add(i+1);                
        }
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}