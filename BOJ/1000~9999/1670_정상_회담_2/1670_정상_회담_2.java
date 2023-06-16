import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		long[] DP = new long[n + 1];

		DP[0] = 1;
		DP[1] = 0;

		for (int i = 2; i <= n; i += 2) {
			for (int j = 0; j < i / 2; ++j) {
				DP[i] += (DP[0 + (j * 2)] * DP[i - 2 - (j * 2)]) % 987654321;
				DP[i] %= 987654321;
			}
		}
				
		bw.write(DP[n] + "\n");
		bw.close();
	}
}