import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static char[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		map = new char[n][n];

		for(int i=0; i<n; ++i) {
			for(int j=0; j<n;++j) {
				map[i][j] = ' ';
			}
		}
		
		recu(0, 0, n);

		for(int i=0; i<n; ++i) {
			for(int j=0; j<n;++j) {
				bw.write(map[i][j]);
			}
			bw.write("\n");
		}
		bw.close();
	}

	public static void recu(int y, int x, int n) {
		if (n == 1) {
			map[y][x] = '*';
			return;
		}
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				if (i == 1 && j == 1) {
					continue;
				}
				recu(y + (i * n / 3), x + (j * n / 3), n / 3);
			}
		}
	}
}