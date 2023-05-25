import java.util.*;

class Solution {
    public String solution(int[] numbers) {        
        String[] strs = new String[numbers.length];
        for (int i=0; i<numbers.length; i++) {
            strs[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(strs, (s2, s1) -> (s1+s2).compareTo(s2+s1));
        
        String answer = "";
        if ("0".equals(strs[0]))
            answer = "0";
        else {
            StringBuilder sb = new StringBuilder();
            for (String s : strs) {
                sb.append(s);
            }
            answer = sb.toString();
        }
        return answer;
    }
}