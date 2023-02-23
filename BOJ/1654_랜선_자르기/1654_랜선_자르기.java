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
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		long[] line = new long[k];
		for(int i=0; i<k; ++i) {
			line[i] = Integer.parseInt(br.readLine());
		}		
		long left = 1;
		long right = (long) Math.pow(2, 31) - 1;
		long mid = -1;
		while(true) {
			if(mid == (long) (right + left) / 2) {
				break;
			}
			mid = (long) (right + left) / 2;
			int size = 0;
			for(int i=0; i<k; ++i) {
				size += (long) line[i] / mid;
			}
			if(size < n) {
				right = mid - 1;
			} else if(size >= n) {
				left = mid + 1;
			}
		}		
		bw.write(mid + "");
		bw.close();
	}
}