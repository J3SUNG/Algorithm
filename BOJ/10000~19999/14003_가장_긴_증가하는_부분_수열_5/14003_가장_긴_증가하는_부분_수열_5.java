import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int cnt;
	static int[] arr;
	static int[] ansArr;
	static ArrayList<Integer> dp;
	static ArrayList<Integer> record;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		dp = new ArrayList<>();
		record = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; ++i) {
			if (dp.size() == 0 || dp.get(dp.size() - 1) < arr[i]) {
				dp.add(arr[i]);
				record.add(dp.size() - 1);
			} else {
				int left = 0;
				int right = dp.size() - 1;
				while (left < right) {
					int mid = (left + right) >> 1;
					if(dp.get(mid) >= arr[i]) {
						right = mid;
					} else {
						left = mid + 1;
					}
				}
				dp.set(right, arr[i]);
				record.add(right);
			}
		}

		cnt = dp.size() - 1;
		ansArr = new int[cnt + 1];
		for(int i=n-1; i>=0; --i) {
			if(record.get(i) == cnt) {
				ansArr[cnt] = arr[i];
				--cnt;
			}
		}
		
		bw.write(dp.size() + "\n");
		for(int i=0; i<ansArr.length; ++i) {
			bw.write(ansArr[i] + " ");
		}
		bw.write("\n");
		bw.close();
	}
}