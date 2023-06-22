import java.util.*;

class Solution {
    int max = Integer.MIN_VALUE;
    public int solution(int k, int[][] dungeons) {
        solve(0, 0, k, dungeons, new boolean[dungeons.length]);
        return max;
    }

    public void solve(int index, int count, int k, int[][] dungeons, boolean[] visited) {
        max = Math.max(max, count);
        for (int i=0; i<dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                solve (index + 1, count + 1, k - dungeons[i][1], dungeons, visited);
                visited[i] = false;
            }
        }
    }
}