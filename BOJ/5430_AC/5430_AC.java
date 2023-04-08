import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int ans = 0;
		int ts = Integer.parseInt(br.readLine());

		for (int t = 0; t < ts; ++t) {
			String com = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String s = br.readLine();
			Boolean chk = false;
			Boolean err = false;
			Deque<Integer> dq = new ArrayDeque<>();
			s = s.substring(1, s.length() - 1);
			String[] arr = s.split(",");

			if (arr[0].equals("")) {
				arr = new String[0];
			}
			
			for (int i = 0; i < arr.length; ++i) {
				dq.add(Integer.parseInt(arr[i]));
			}

			for (int i = 0; i < com.length(); ++i) {
				if (com.charAt(i) == 'R') {
					chk = !chk;
				} else if (com.charAt(i) == 'D') {
					if (dq.size() == 0) {
						bw.write("error\n");
						err = true;
						break;
					}
					if (chk) {
						dq.removeLast();
					} else {
						dq.removeFirst();
					}
				}
			}

			if (err) {
				continue;
			}

			bw.write("[");
			if (!dq.isEmpty()) {
				if (chk) {
					bw.write(dq.getLast() + "");
					dq.removeLast();
				} else {
					bw.write(dq.getFirst() + "");
					dq.removeFirst();
				}
			}
			while (!dq.isEmpty()) {
				if (chk) {
					bw.write("," + dq.getLast());
					dq.removeLast();
				} else {
					bw.write("," + dq.getFirst());
					dq.removeFirst();
				}
			}
			bw.write("]\n");
		}
		bw.close();
	}
}
