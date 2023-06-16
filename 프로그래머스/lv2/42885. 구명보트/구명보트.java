import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int s = 0, e = people.length-1;
        while (s <= e) {
            if (people[s] + people[e] <= limit) {
                s++;
            }
            answer++;
            e--;
        }
        return answer;
    }
}