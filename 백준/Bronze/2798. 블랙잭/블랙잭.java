import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] changes = {500, 100, 50, 10, 5, 1};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cards = new int[n];
        for (int i=0; i<n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);
        int max = 0;
        for (int i=0; i<=n-3; i++) {
            for (int j=i+1; j<=n-2; j++) {
                for (int w=j+1; w<=n-1; w++) {
                    int sum = cards[i] + cards[j] + cards[w];
                    if (sum > m) break;
                    max = Math.max(max, sum);
                }
            }
        }
        System.out.println(max);
    }
}