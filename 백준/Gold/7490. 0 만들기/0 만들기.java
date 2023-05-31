import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i=0, n=0; i<tc; i++) {
            n = Integer.parseInt(br.readLine());
            solve(1, n, 1, 1, 0, "1");
            System.out.println();
        }
    }

    public static void solve(int depth, int end, int numToSum, int op, int sum, String str) {
        if (depth == end) {
            sum += numToSum * op;
            if (sum == 0) {
                System.out.println(str);
            }
            return;
        }
        solve(depth+1, end, numToSum*10+(depth+1), op, sum, str+" "+(depth+1));
        solve(depth+1, end, depth+1, 1, sum + (numToSum*op),str+"+"+ (depth+1));
        solve(depth+1, end, depth+1, -1, sum + (numToSum*op),str+"-"+(depth+1));
    }
}