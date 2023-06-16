import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int n;
	static int[] DP = new int[1001];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		DP[1] = 1;
		DP[2] = 0;
		DP[3] = 1;
		DP[4] = 1;
		for(int i=5; i<1001; ++i) {
			if((DP[i-1] & DP[i-3] & DP[i-4]) == 1) {
				DP[i] = 0;
			} else {
				DP[i] = 1;
			}
		}
		
		bw.write(DP[n]==1?"SK":"CY");
		bw.close();
	}
}