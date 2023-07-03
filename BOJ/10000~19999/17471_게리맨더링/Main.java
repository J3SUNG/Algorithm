import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int ans = 987654321;
	static int n;
	static int[] po;
	static ArrayList<ArrayList<Integer>> al;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		n = Integer.parseInt(br.readLine());
		po = new int[n + 1];
		al = new ArrayList<>();
		st = new StringTokenizer(br.readLine());

		ArrayList<Integer> temp = new ArrayList<>();
		al.add(temp);
		for (int i = 1; i <= n; ++i) {
			temp = new ArrayList<>();
			al.add(temp);
			po[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= n; ++i) {
			st = new StringTokenizer(br.readLine());
			int conn = Integer.parseInt(st.nextToken());
			for (int j = 1; j <= conn; ++j) {
				int num = Integer.parseInt(st.nextToken());
				al.get(i).add(num);
			}
		}

		for (int i = 1; i <= n; ++i) {
			makeCom(i, (1 << i));
		}

		ans = ans == 987654321 ? -1 : ans;
		bw.write(ans + "\n");
		bw.close();
	}

	public static void checkArea(int index, int bool, int bit, int[] visit) {
		for (int i = 0; i < al.get(index).size(); ++i) {
			int nextIndex = al.get(index).get(i);
			if (visit[nextIndex] == 1) {
				continue;
			}
			if ((bool == 0 && (bit & (1 << nextIndex)) == 0) || (bool == 1 && (bit & (1 << nextIndex)) != 0)) {
				visit[nextIndex] = 1;
				checkArea(nextIndex, bool, bit, visit);
			}
		}
	}

	public static void checkDiv(int bit) {
		int[] visit = new int[n + 1];
		int aVal = 0;
		int bVal = 0;
		for (int i = 1; i <= n; ++i) {
			if ((bit & (1 << i)) == 0) {
				visit[i] = 1;
				checkArea(i, 0, bit, visit);
				break;
			}
		}
		for (int i = 1; i <= n; ++i) {
			if ((bit & (1 << i)) != 0) {
				visit[i] = 1;
				checkArea(i, 1, bit, visit);
				break;
			}
		}
		for (int i = 1; i <= n; ++i) {
			if (visit[i] == 0) {
				return;
			}
			if ((bit & (1 << i)) == 0) {
				aVal += po[i];
			} else if ((bit & (1 << i)) != 0) {
				bVal += po[i];
			}
		}
		ans = Math.min(ans, Math.abs(aVal - bVal));
	}

	public static void makeCom(int index, int bit) {
		checkDiv(bit);
		for (int i = index; i <= n; ++i) {
			makeCom(i + 1, (bit | (1 << i)));
		}
	}
}