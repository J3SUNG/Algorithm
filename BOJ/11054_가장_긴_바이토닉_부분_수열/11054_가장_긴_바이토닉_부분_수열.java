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
		int[] upDP = new int[n+1];
		int[] downDP = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<=n; ++i) {
			for(int j=i+1; j<=n; ++j) {
				if(arr[i] < arr[j]) {  
					upDP[j] = Math.max(upDP[j], upDP[i] + 1);
				}
				if(arr[n-i] < arr[n-j]) {  
					downDP[n-j] = Math.max(downDP[n-j], downDP[n-i] + 1);
				}
			}
		}
		
		for(int i=1; i<=n; ++i) {
			ans = Math.max(ans, upDP[i] + downDP[i]);
		}		
		
		bw.write(ans + "\n");		
		bw.close();
	}
}