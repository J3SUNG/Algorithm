import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int ans = 0;
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		int[] DP = new int[n+1];
		int[] ansArr;
		int cnt;
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<=n; ++i) {
			for(int j=i+1; j<=n; ++j) {
				if(arr[i] < arr[j]) {  
					DP[j] = Math.max(DP[j], DP[i] + 1);
				}
			}
		}
				
		for(int i=1; i<=n; ++i) {
			ans = Math.max(ans, DP[i]);
		}		
		
		cnt = ans;
		ansArr = new int[ans];
		for(int i=n; i>0; --i) {
			if(DP[i] == cnt) {
				--cnt;
				ansArr[cnt] = arr[i];
			}
		}
		
		bw.write(ans + "\n");		
		for(int i=0; i<ansArr.length; ++i) {
			bw.write(ansArr[i] + " ");
		}
		bw.write("\n");		
		bw.close();
	}
}