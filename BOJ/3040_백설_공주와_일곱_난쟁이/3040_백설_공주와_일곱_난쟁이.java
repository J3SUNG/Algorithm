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
		int ans = 0;
		int sum = 0;
		int[] man = new int[9];
		int[] arr = new int[9];
		for(int i=0; i<9; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
			man[i] = arr[i];
			sum += arr[i];
		}
		Arrays.sort(arr);
		int findNum = sum - 100;
		int left = 0;
		int right = 8;
		while(true) {
			if(arr[left] + arr[right] == findNum) {
				break;
			}
			if(findNum > arr[left] + arr[right]) {
				++left; 
			} else {
				--right;
			}
		}
		
		for(int i=0; i<9; ++i) {
			if(man[i] == arr[left] || man[i] == arr[right]) {
				continue;
			}
			bw.write(man[i] + "\n");
		}
				
		bw.close();
	}
}