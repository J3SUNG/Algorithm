import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int ans = 0;
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int[] arr = new int[m + 1];

		for (int i = 0; i < m; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		arr[m] = l;

		for (int i = 0; i < n; ++i) {
			int num = Integer.parseInt(br.readLine());
			int left = 0;
			int right = l;
			while (left <= right) {
				int cnt = 0;
				int prev = 0;
				int mid = (left + right) / 2;
				for (int j = 0; j <= m; ++j) {
					if (arr[j] - prev >= mid) {
						++cnt;
						prev = arr[j];
					}
				}
				if (cnt > num) {
					left = mid + 1;
					ans = Math.max(ans, mid);
				} else {
					right = mid - 1;
				}
			}
			bw.write(right + "\n");
		}
		bw.close();
	}
}