import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class Main {
	static int ans;
	static int n;
	static int m;
	static int k;
	static int work[];
	static int visit[];
	static ArrayList<ArrayList<Integer>> al = new ArrayList<>();
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
 
		ans = 0;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		work = new int[m + 1];
		visit = new int[n + 1];
 
		for (int i = 0; i <= n; ++i) {
			ArrayList<Integer> temp = new ArrayList<>();
			al.add(temp);
		}
 
		for (int i = 1; i <= n; ++i) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < cnt; ++j) {
				al.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}
 
		for (int i = 1; i <= n; ++i) {
			if (DFS(i) == 1) {
				++ans;
			}
			for (int j = 1; j <= n; ++j) {
				visit[j] = 0;
			}
		}
	
		boolean chk = true;
		for (int t = 0; t < k; ++t) {
			if(!chk) {
				break;
			}
			for (int i = 1; i <= n; ++i) {
				for (int j = 1; j <= n; ++j) {
					visit[j] = 0;
				}
				
				if (DFS(i) == 1) {
					chk = true;
					++ans;
					break;
				} else {
					chk = false;
				}
			}
		}
 
		bw.write(ans + "\n");
		bw.close();
	}
 
	public static int DFS(int user) {
		if (visit[user] == 1) {
			return 0;
		}
		visit[user] = 1;
 
		for (int i = 0; i < al.get(user).size(); ++i) {
			int job = al.get(user).get(i);
 
			int next = work[job];
			if (work[job] == 0 || DFS(next) == 1) {
				work[job] = user;
				return 1;
			}
		}
		return 0;
	}
}