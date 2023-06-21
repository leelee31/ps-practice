import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for (int length=1; length<=yellow; length++) {
            if (yellow % length != 0) continue;
            int width = yellow / length;
            if (length > width)
                break;
            if (2 * (length + width + 2) == brown) {
                answer[0] = width + 2;
                answer[1] = length + 2;
                break;
            }
        }
        return answer;
    }
}