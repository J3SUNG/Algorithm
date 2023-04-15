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
		StringTokenizer st = new StringTokenizer(br.readLine());

		int ans = 0;
		int n = Integer.parseInt(st.nextToken());
		int[] time = new int[n + 1];
		int[] cnt = new int[n + 1];
		int[] size = new int[n + 1];
		Queue<Data> q = new LinkedList<>();
		ArrayList<ArrayList<Integer>> al = new ArrayList<>();

		al.add(new ArrayList<>());
		for (int i = 1; i <= n; ++i) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());

			al.add(new ArrayList<>());

			int m = Integer.parseInt(st.nextToken());
			cnt[i] = m;
			if (m == 0) {
				q.add(new Data(i, time[i]));
			}
			for (int j = 0; j < m; ++j) {
				al.get(Integer.parseInt(st.nextToken())).add(i);
			}
		}

		while (!q.isEmpty()) {
			Data d = q.poll();
			--cnt[d.index];
			size[d.index] = Math.max(size[d.index], d.time);
			if (cnt[d.index] > 0) {
				continue;
			}
			
			for (int i = 0; i < al.get(d.index).size(); ++i) {
				int next = al.get(d.index).get(i);
				q.add(new Data(next, size[d.index] + time[next]));
			}
		}

		for (int i = 1; i <= n; ++i) {
			ans = Math.max(ans, size[i]);
		}

		bw.write(ans + "\n");
		bw.close();
	}

	public static class Data {
		int index;
		int time;

		public Data(int index, int time) {
			this.index = index;
			this.time = time;
		}
	}
}