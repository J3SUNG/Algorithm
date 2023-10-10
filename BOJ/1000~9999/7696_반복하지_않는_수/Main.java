import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] ans = new int[30000001];
		int[] arr = new int[1000001];
		int temp;
		boolean chk;

		for (int i = 0; i < 10; ++i) {
			ans[i] = (1 << i);
			arr[i] = i;
		}

		int i = 10;
		int index = 10;

		while (true) {
			if (ans[i / 10] == 0) {
				++i;
				continue;
			}
			if ((ans[i / 10] & ans[i % 10]) == 0) {
				ans[i] = ans[i / 10] | ans[i % 10];
				arr[index] = i;
				++index;
			}
			++i;
			if (index > 1000000) {
				break;
			}
		}

		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) {
				break;
			}
			bw.write(arr[n] + "\n");
		}
		bw.close();
	}
}