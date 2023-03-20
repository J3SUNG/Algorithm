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
	static int[] visit = new int[1001];
	static ArrayList<ArrayList<Pair>> al;
	static BufferedReader br;
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		al = new ArrayList<>();

		for (int i = 0; i <= n; ++i) {
			ArrayList<Pair> temp = new ArrayList<>();
			al.add(temp);
		}

		for (int i = 0; i < n - 1; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			al.get(a).add(new Pair(b, c));
			al.get(b).add(new Pair(a, c));
		}

		for (int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			visit[start] = 1;
			DFS(start, end, 0);
			visit[start] = 0;
		}

		bw.close();
	}
	
	public static void DFS(int s, int e, int num) throws IOException {
		if(s == e) {
			bw.write(num + "\n");
			return;
		}
		for(int i=0; i<al.get(s).size(); ++i) {
			if(visit[al.get(s).get(i).link] == 1) {
				continue;
			}
			visit[al.get(s).get(i).link] = 1;
			DFS(al.get(s).get(i).link, e, num + al.get(s).get(i).value);
			visit[al.get(s).get(i).link] = 0;
		}
	}

	public static class Pair {
		public int link;
		public int value;
		public Pair(int link, int value) {
			this.link = link;
			this.value = value;
		}
	}
}