import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> answer = new ArrayList<>();
        for (int i=0, temp=-1; i<arr.length; i++) {
            if (temp != arr[i]) {
                temp = arr[i];
                answer.add(temp);                
            }
        }
        return answer.stream()
            .mapToInt(x -> x)
            .toArray();
    }
}