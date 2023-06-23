import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while ((st = new StringTokenizer(br.readLine())) != null) {
            int[] tri = new int[3];
            tri[0] = Integer.parseInt(st.nextToken());
            if (tri[0] == 0) break;
            tri[1] = Integer.parseInt(st.nextToken());
            tri[2] = Integer.parseInt(st.nextToken());
            Arrays.sort(tri);
            if (tri[2] >= tri[0] + tri[1])
                sb.append("Invalid");
            else if (tri[0] == tri[2])
                sb.append("Equilateral");
            else if (tri[0] == tri[1] || tri[1] == tri[2])
                sb.append("Isosceles");
            else
                sb.append("Scalene");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}