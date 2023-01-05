import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int ans = 0;
	static int n;
	static int m;
	static int[] visit;
	static ArrayList<ArrayList<Integer>> arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visit = new int[n];
		arr = new ArrayList<>();
		for(int i=0; i<n; ++i) {
			ArrayList<Integer> temp = new ArrayList<>();
			arr.add(temp);
		}
		for(int i=0; i<m; ++i) {			
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr.get(a).add(b);
			arr.get(b).add(a);
		}
		
		for(int i=0; i<n; ++i) {
			visit[i] = 1;
			DFS(i, 1);
			visit[i] = 0;
		}
		
		bw.write(ans + "");
		bw.close();
	}
	public static void DFS(int index, int cnt) {
		if(cnt == 5 || ans == 1) {
			ans = 1;
			return;
		}
		for(int i=0; i<arr.get(index).size(); ++i) {
			int nextIndex = arr.get(index).get(i);
			if(visit[nextIndex] == 1) {
				continue;
			}
			visit[nextIndex] = 1;
			DFS(nextIndex, cnt+1);
			visit[nextIndex] = 0;			
		}
	}
}