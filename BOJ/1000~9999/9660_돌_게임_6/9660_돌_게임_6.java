import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static long n;
	static int[] ans = new int[7];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Long.parseLong(br.readLine()) - 1;
		n %= 7;
		ans[0] = 1;
		ans[1] = 0;
		ans[2] = 1;
		ans[3] = 1;
		ans[4] = 1;
		ans[5] = 1;
		ans[6] = 0;		
		bw.write(ans[(int) n]==1?"SK":"CY");
		bw.close();
	}
}