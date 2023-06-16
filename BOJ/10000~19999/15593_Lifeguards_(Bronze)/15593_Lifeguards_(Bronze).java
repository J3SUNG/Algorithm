import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] time = new int[1001];
		int[][] arr = new int[n][2];
		int total = 0;
		for(int i=0; i<n; ++i) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			for(int j=arr[i][0]; j<arr[i][1]; ++j) {
				if(time[j] == 0) {
					++total;
				}
				++time[j];
			}
		}
		int cnt = 987654321;
		for(int i=0; i<n; ++i) {
			int c = 0;
			for(int j=arr[i][0]; j<arr[i][1]; ++j) {
				if(time[j]<=1) {
					++c;
				}
			}
			cnt = Math.min(cnt, c);
		}
		
		bw.write(total - cnt + "");
		bw.close();
	}
}