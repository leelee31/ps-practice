import java.io.*;

import java.math.BigInteger;
import java.util.*;

public class Main {
    public static int h,w;
    public static char[][] wordMap;
    public static String word;
    public static long[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        wordMap = new char[h][w];
        dp = new long[h][w][101];
        for (int i=0; i<h; i++) {
            wordMap[i] = br.readLine().toCharArray();
            for (int j=0; j<w; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        word = br.readLine();

        long answer = 0;
        for (int i=0; i<h; i++) {
            for (int j=0; j<w; j++) {
                if (wordMap[i][j] == word.charAt(0))
                    answer += solve(i, j, 0);
            }
        }
        System.out.println(answer);
    }

    public static int[] posX = {1, -1, 0, 0, 1, -1, 1, -1};
    public static int[] posY = {0, 0, 1,-1, 1, -1, -1, 1};

    public static long solve(int x, int y, int pos) {
        if (dp[x][y][pos] != -1) return dp[x][y][pos];
        dp[x][y][pos] = 0;
        if (pos == word.length()-1 && wordMap[x][y] == word.charAt(pos)) {
            dp[x][y][pos] = 1;
            return dp[x][y][pos];
        }

        for (int i=0; i<8; i++) {
            int tempX = x + posX[i];
            int tempY = y + posY[i];
            if (tempX<0 || tempX>=h || tempY<0 || tempY>=w) continue;
            if (wordMap[tempX][tempY] == word.charAt(pos+1))
                dp[x][y][pos] += solve(tempX, tempY, pos+1);
        }
        
        return dp[x][y][pos];
    }
}