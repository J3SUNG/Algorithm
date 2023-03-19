import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int l;
	static int[] arr;
	static int[] dis;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int ans = 0;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		arr = new int[n + 1];
		dis = new int[n + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		arr[n] = l;
		Arrays.sort(arr);

		int a = 0;
		int b = 0;
		int max = 0;
		for (int i = 0; i < n + 1; ++i) {
			a = arr[i];
			dis[i] = a - b;
			max = Math.max(max, dis[i]);
			b = a;
		}

		int left = 1;
		int right = max;
		int mid;
		while (left <= right) {
			mid = (left + right) >> 1;
			int cnt = m;
			for (int i = 0; i < n + 1; ++i) {
				if(mid >= dis[i]) {
					continue;
				}
				cnt -= ((dis[i] + mid - 1) / mid) - 1;
				if (cnt < 0) {
					break;
				}
			}
			if (cnt < 0) {
				left = mid + 1;
			} else {
				ans = mid;
				right = mid - 1;
			}
		}

		bw.write(ans + "\n");
		bw.close();
	}
}