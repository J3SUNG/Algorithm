import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int bus = Integer.parseInt(br.readLine());
    int[][] map = new int[n][n];

    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < n; ++j) {
        map[i][j] = 987654321;
      }
    }

    for (int i = 0; i < bus; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;
      int c = Integer.parseInt(st.nextToken());
      map[a][b] = Math.min(map[a][b], c);
    }

    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < n; ++j) {
        for (int k = 0; k < n; ++k) {
          map[j][k] = Math.min(map[j][k], map[j][i] + map[i][k]);
        }
      }
    }

    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < n; ++j) {
        if (i == j || map[i][j] == 987654321) {
          map[i][j] = 0;
        }
        bw.write(map[i][j] + " ");
      }
      bw.write("\n");
    }

    bw.close();
  }
}