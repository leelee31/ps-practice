import java.util.*;

class Solution {
    int order = 1;
    public int solution(String word) {
        Map<String, Integer> map = new HashMap<>();
        makeIndex(0, map, new char[]{'A','E','I','O','U'}, "");
        return map.get(word);
    }
    
    public void makeIndex(int index, Map<String, Integer> map, char[] cArr, String str) {
        if (index == cArr.length) return;
        for (int i=0; i<cArr.length; i++) {
            map.put(str + cArr[i], order++);
            makeIndex(index + 1, map, cArr, str + cArr[i]);
        }
    }
}