import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[] buttons = {300, 60, 10};
        int[] counts = new int[3];
        for (int i=0, count=0; i<buttons.length; i++) {
            count = 0;
            for (int j=buttons[i]; j<=T; j++) {
                count = T / buttons[i];
                T -= buttons[i] * count;
            }
            counts[i] = count;
        }

        String answer = "";
        if (T == 0) {
            for (int c : counts) {
                answer += c + " ";
            }
        } else {
            answer = "-1";
        }
        System.out.println(answer);
    }
}