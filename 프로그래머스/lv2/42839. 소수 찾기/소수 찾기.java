import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    int[] nums;
    boolean[] visited;

    public int solution(String numbers) {
        nums = new int[numbers.length()];
        visited = new boolean[nums.length];
        
        for (int i=0; i<nums.length; i++) {
            nums[i] = numbers.charAt(i) - '0';
        }

        dfs("");

        return set.size();
    }

    public void dfs(String str) {
        for (int i=0; i<nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(str + nums[i]);
                visited[i] = false;
            } else {
                int num = Integer.parseInt(str);
                if (isPrime(num) && !set.contains(num)) {
                    set.add(num);
                }
            }
        }
    }

    public boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i=2; i<number; i++)
            if (number % i == 0) return false;
        return true;
    }
}