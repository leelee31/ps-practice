import java.util.*;

class Solution {
    int[] pX = {1, -1, 0, 0};
    int[] pY = {0, 0, 1, -1};
    int[][] maps;
    int[][] visited;
    
    public int solution(int[][] input) {
        int n = input.length;
        int m = input[0].length;
        maps = input;
        visited = new int[n][m];
        solve(0, 0);
        return visited[n-1][m-1] != 0 ? visited[n-1][m-1] : -1;
    }

    public void solve(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visited[x][y] = 1;
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i=0; i<4; i++) {
                int tX = node.x + pX[i];
                int tY = node.y + pY[i];
                if (isNotAvailableWay(tX, tY)) continue;
                q.add(new Node(tX, tY));
                visited[tX][tY] = visited[node.x][node.y] + 1;
            }
        }
    }
    
    public boolean isNotAvailableWay(int x, int y) {
        return x < 0 || x >= maps.length || y < 0 || y >= maps[0].length 
            || maps[x][y] == 0 || visited[x][y] != 0;
    }
}

class Node {
    public int x;
    public int y;
    public Node(int x, int y) {
        this.x = x; this.y = y;
    }
}