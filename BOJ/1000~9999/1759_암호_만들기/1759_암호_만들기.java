import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static char[] vowels = {'a', 'e', 'i', 'o', 'u'};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		String[] arr = new String[m];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; ++i) {
			arr[i] = st.nextToken();
		}
		Arrays.sort(arr);
		
		for(int i=0; i<m; ++i) {
			String str = arr[i];
			DFS(i+1, n, m, arr, str);
		}
	}
	public static void DFS(int index, int n, int m, String[] arr, String str) {
		if(str.length() == n) {
			int vow = 0;
			for(int i=0; i<str.length(); ++i) {
				for(int j=0; j<5; ++j) {
					if(str.charAt(i) == vowels[j]) {
						++vow;
					}
				}
			}
			if(vow > 0 && vow < str.length() - 1) {
				System.out.println(str);
			}
			return;
		}
		for(int i=index; i<m; ++i) {
			DFS(i+1, n, m, arr, str + arr[i]);
		}
	}
}