import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        Stack<Integer> dels = new Stack<>();
        Stack<Integer> picks = new Stack<>();
        for (int d : deliveries) {
            dels.push(d);
        }
        for (int p : pickups) {
            picks.push(p);
        }
        long answer = 0;
        while (!dels.isEmpty() || !picks.isEmpty()) {
            while (!dels.isEmpty() && dels.peek() == 0) {
                dels.pop();
            }
            while(!picks.isEmpty() && picks.peek() == 0) {
                picks.pop();
            }
            int delLen = dels.isEmpty() ? 0 : dels.size();
            int pickLen = picks.isEmpty() ? 0 : picks.size();
            answer += Math.max(delLen, pickLen) * 2;
            int toDel = cap;
            while (!dels.isEmpty() && toDel > 0) {
                if (dels.peek() <= toDel) {
                    toDel -= dels.pop();
                } else {
                    dels.push(dels.pop() - toDel);
                    break;
                }
            }
            int toPick = cap;
            while (!picks.isEmpty() && toPick > 0) {
                if (picks.peek() <= toPick) {
                    toPick -= picks.pop();
                } else {
                    picks.push(picks.pop() - toPick);
                    break;
                }
            }
        }
        return answer;
    }
}