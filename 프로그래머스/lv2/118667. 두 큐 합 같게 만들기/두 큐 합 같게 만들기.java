import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        int q1Sum = 0;
        int q2Sum = 0;
        for (int q : queue1) {
            q1Sum += q;
            q1.offer(q);
        }
        for (int q: queue2) {
            q2Sum += q;
            q2.offer(q);            
        }
        
        int answer = 0;
        if ((q1Sum+q2Sum)%2 != 0) 
            answer = -1;
        else {
            answer = 0;
            long q1TempSum = q1Sum;
            long q2TempSum = q2Sum;
            while (true) {
                if (q1TempSum == q2TempSum || answer >= 3000000) {
                    break;
                } else if (q1TempSum > q2TempSum) {
                    int temp = q1.poll();
                    q1TempSum -= temp;
                    q2.offer(temp);
                    q2TempSum += temp;
                } else {
                    int temp = q2.poll();
                    q2TempSum -= temp;
                    q1.offer(temp);
                    q1TempSum += temp;               
                }
                answer++;
            }
            answer = q1TempSum == q2TempSum ? answer : -1;
        }
        return answer;
    }
}