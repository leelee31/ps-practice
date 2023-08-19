import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		int count = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		int[] coin = new int[count];

		for (int i = 0; i < count; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			coin[i] = Integer.parseInt(st.nextToken());
		}

		int idx = count;
		int result = 0;
		while (k > 0) {
			int tempIdx = --idx;
			if (k / coin[tempIdx] > 0) {
				result += k / coin[tempIdx];
				k = k % coin[tempIdx];
			}
		}

		System.out.println(result);
	}
}