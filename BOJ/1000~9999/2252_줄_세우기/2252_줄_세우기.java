import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] size = new int[n + 1];
		Queue<Integer> q = new LinkedList<>();
		ArrayList<ArrayList<Integer>> al = new ArrayList<>();

		for (int i = 0; i <= n; ++i) {
			ArrayList<Integer> temp = new ArrayList<>();
			al.add(temp);
		}

		for (int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			al.get(a).add(b);
			++size[b];
		}

		for (int i = 1; i <= n; ++i) {
			if (size[i] == 0) {
				q.add(i);
			}
		}

		while (!q.isEmpty()) {
			int index = q.poll();
			if (size[index] > 1) {
				--size[index];
				continue;
			}
			
			bw.write(index + " ");
			for (int i = 0; i < al.get(index).size(); ++i) {
				q.add(al.get(index).get(i));
			}
		}

		bw.close();
	}
}
