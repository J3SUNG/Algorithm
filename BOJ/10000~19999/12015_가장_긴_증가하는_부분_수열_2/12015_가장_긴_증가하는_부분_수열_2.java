import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] arr;
	static ArrayList<Integer> dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int ans = 0;
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		dp = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; ++i) {
			if (dp.size() == 0 || dp.get(dp.size() - 1) < arr[i]) {
				dp.add(arr[i]);
			} else {
				int left = 0;
				int right = dp.size() - 1;
				while (left < right) {
					int mid = (left + right) >> 1;
					if(dp.get(mid) >= arr[i]) {
						right = mid;
					} else {
						left = mid + 1;
					}
				}
				dp.set(right, arr[i]);
			}
		}

		bw.write(dp.size() + "\n");
		bw.close();
	}
}