import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] top = new int[n+1];
		int[] receive = new int[n+1];
		Stack<Pair> stack = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; ++i) {
			top[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=n; i>0; --i) {
			if(top[i] < top[i-1]) {
				receive[i] = i-1;
				while(!stack.isEmpty() && stack.peek().num < top[i-1]){
					receive[stack.peek().index] = i-1;
					stack.pop();
				}
				continue;
			}
			stack.push(new Pair(top[i], i));
		}
		
		for(int i=1; i<=n; ++i) {
			bw.write(receive[i] + " ");
		}
		bw.write("\n");
		bw.close();
	}
	public static class Pair {
		int num, index;
		public Pair(int num, int index) {
			this.num = num;
			this.index = index;
		}
	}
}
