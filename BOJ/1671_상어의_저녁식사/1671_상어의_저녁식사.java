import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int ans;
	static int n;
	static int visitCnt;
	static Data[] sharks;
	static int visit[];
	static int eat[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		ans = 0;
		n = Integer.parseInt(st.nextToken());
		sharks = new Data[n + 1];
		visit = new int[n + 1];
		eat = new int[n + 1];

		for (int i = 1; i <= n; ++i) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());
			int brain = Integer.parseInt(st.nextToken());
			sharks[i] = new Data(size, speed, brain);
		}

		for (int i = 1; i <= n; ++i) {
			++visitCnt;
			if (DFS(i) == 1) {
				++ans;
			}
			++visitCnt;
			if (DFS(i) == 1) {
				++ans;
			}
		}

		bw.write(n - ans + "\n");
		bw.close();
	}

	public static int DFS(int loc) {
		if (visit[loc] == visitCnt) {
			return 0;
		}
		visit[loc] = visitCnt;

		for (int i = 1; i <= n; ++i) {
			if (loc == i) {
				continue;
			}

			if (eat(loc, i)) {
				if (eat[i] == 0 || DFS(eat[i]) == 1) {
					eat[i] = loc;
					return 1;
				}
			}
		}

		return 0;
	}

	public static boolean eat(int a, int b) {
		if (sharks[a].size == sharks[b].size && sharks[a].speed == sharks[b].speed && sharks[a].brain == sharks[b].brain
				&& a < b) {
			return false;
		}

		if (sharks[a].size >= sharks[b].size && sharks[a].speed >= sharks[b].speed && sharks[a].brain >= sharks[b].brain) {
			return true;
		}

		return false;
	}

	public static class Data {
		int size;
		int speed;
		int brain;

		public Data(int size, int speed, int brain) {
			this.size = size;
			this.speed = speed;
			this.brain = brain;
		}
	}
}