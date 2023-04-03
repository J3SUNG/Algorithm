import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[] p;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int ans = 0;
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		p = new int[n];
		
		for(int i=0; i<n; ++i) {
			p[i] = i;
		}
		
		for(int i=1; i<=m; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if(find(a) == find(b)) {
				ans = i;
				break;
			}
			
			if(p[a] < p[b]) {
				p[p[b]] = p[a];
			} else {
				p[p[a]] = p[b];
			}
		}
		bw.write(ans + "\n");
		bw.close();
	}
	
	public static int find(int num) {
		if(num == p[num]) {
			return num;
		}
		
		int result = find(p[num]);
		p[num] = result;
		return result;
	}
}
