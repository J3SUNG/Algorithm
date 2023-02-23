import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> qt = new LinkedList<>();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] ans = new int [100001];
		int t = 0;
		
		for(int i=0; i<=100000; ++i) {
			ans[i] = -1;
		}
		
		q.add(n);
		qt.add(t);
		ans[n] = t;
		while(!q.isEmpty()) {
			int curLoc = q.poll();
			int curTime = qt.poll();
			if(curLoc - 1 >= 0) {
				if(ans[curLoc-1] == -1 || ans[curLoc-1] > curTime + 1) {
					q.add(curLoc - 1);
					qt.add(curTime + 1);
					ans[curLoc - 1] = curTime + 1;
				}
			}
			if(curLoc + 1 <= 100000) {
				if(ans[curLoc+1] == -1 || ans[curLoc+1] > curTime + 1) {
					q.add(curLoc + 1);
					qt.add(curTime + 1);
					ans[curLoc + 1] = curTime + 1;
				}
			}
			if(curLoc * 2 <= 100000) {
				if(ans[curLoc*2] == -1 || ans[curLoc*2] > curTime + 1) {
					q.add(curLoc * 2);
					qt.add(curTime + 1);
					ans[curLoc * 2] = curTime + 1;
				}
			}
		}
		bw.write(ans[m] + "\n");
		bw.close();
	}
}
