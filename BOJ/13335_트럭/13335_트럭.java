import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int ans = 0;
		int[] truck = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; ++i) {
			truck[i] = Integer.parseInt(st.nextToken());
		}
		int weight = 0;
		Queue<Integer> q = new LinkedList<>();
		for(int i=0; i<w; ++i) {
			q.add(0);
		}
		
		int index = 0;
		while(!q.isEmpty()) {
			++ans;
			weight -= q.poll();
			if(index >= truck.length) {
				continue;
			}
			if(weight + truck[index] <= l) {
				weight += truck[index];
				q.add(truck[index]);
				++index;
			} else {
				q.add(0);
			}
		}
		
		
		bw.write(ans + "");
		bw.close();
	}
}