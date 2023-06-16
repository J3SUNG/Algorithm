import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<ArrayList<Pair>> al = new ArrayList<>();
		PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)-> a.num - b.num);
		
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(br.readLine());
		int[] dis = new int[v+1];
		
		for(int i=0; i<=v; ++i) {
			ArrayList<Pair> temp = new ArrayList<>();
			al.add(temp);
			dis[i] = 987654321;
		}
		
		for(int i=0; i<e; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			al.get(a).add(new Pair(b, c));
		}
		
		dis[s] = 0;
		pq.add(new Pair(s, dis[s]));
		while(!pq.isEmpty()) {
			Pair cur = pq.poll();
			
			for(int i=0; i<al.get(cur.ver).size(); ++i) {
				int next = al.get(cur.ver).get(i).ver;
				int nextDis = al.get(cur.ver).get(i).num;
				if(dis[next] > dis[cur.ver] + nextDis) {
					dis[next] = dis[cur.ver] + nextDis;
					pq.add(new Pair(next, dis[next]));
				}
			}
		}		
		
		for(int i=1; i<=v; ++i) {
			bw.write(dis[i]==987654321?"INF\n":dis[i] + "\n");
		}
		bw.close();
	}

	public static class Pair {
		public int ver;
		public int num;

		Pair(int ver, int num) {
			this.ver = ver;
			this.num = num;
		}
	}
}