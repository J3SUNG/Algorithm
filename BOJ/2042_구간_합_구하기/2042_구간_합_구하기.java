import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int k;
	static long[] arr;
	static long[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = new long[n + 1];
		tree = new long[n * 4];
		for (int i = 1; i <= n; ++i) {
			arr[i] = Long.parseLong(br.readLine());
		}
		init(1, n, 1);

		for (int i = 0; i < m + k; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());

			if (a == 1) {
				update(1, n, b, c - arr[b], 1);
				arr[b] = c;
			} else if (a == 2) {
				long sum = search(1, n, b, (int)c, 1);
				bw.write(sum + "\n");
			}
		}
		bw.close();
	}
	public static long search(int start, int end, int left, int right, int index) {
		if(end < left || start > right) {
			return 0;
		}
		if(start >= left && end <= right) {
			return tree[index];
		}
		int mid = (start + end) / 2;
		
		return search(start, mid, left, right, index * 2) + search(mid + 1, end, left, right, index * 2 + 1);
	}
	
	public static void update(int start, int end, int cur, long val, int index) {
		if (cur < start || cur > end) {
			return;
		}
		tree[index] += val;
		if (start == end) {
			return;
		}
		int mid = (start + end) / 2;
		update(start, mid, cur, val, index * 2);
		update(mid + 1, end, cur, val, index * 2 + 1);
	}

	public static long init(int start, int end, int index) {
		if (start == end) {
			tree[index] = arr[start];
			return tree[index];
		}

		int mid = (start + end) / 2;
		tree[index] = init(start, mid, index * 2) + init(mid + 1, end, index * 2 + 1);
		return tree[index];
	}
}
