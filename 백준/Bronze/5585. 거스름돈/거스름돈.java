import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] changes = {500, 100, 50, 10, 5, 1};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = 1000 - Integer.parseInt(br.readLine());
        int count = 0;
        for (int c : changes) {
            count += k / c;
            k %= c;
        }
        System.out.println(count);
    }
}