import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  static int n;
  static int[][] arr;
  static int result;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    result = 0;

    if (n == 1) {
      bw.write("1\n");
    } else {
      for (int i = 1; i <= n; ++i) {
        arr = new int[n + 1][n + 1];
        arr[1][i] = 7;
        dfs(2);
      }
      bw.write(result + "\n");
    }

    bw.close();
  }

  public static void dfs(int cnt) {
    for (int i = 1; i <= n; ++i) {
      if ((arr[cnt - 1][i] & 1) != 0 && i > 1) {
        arr[cnt][i - 1] = (1 | arr[cnt][i - 1]);
      }

      if ((arr[cnt - 1][i] & 2) != 0) {
        arr[cnt][i] = (2 | arr[cnt][i]);
      }

      if ((arr[cnt - 1][i] & 4) != 0 && i < n) {
        arr[cnt][i + 1] = (4 | arr[cnt][i + 1]);
      }
    }

    for (int i = 1; i <= n; ++i) {
      if (arr[cnt][i] == 0) {
        if (cnt == n) {
          ++result;
          continue;
        }
        arr[cnt][i] = 7;
        dfs(cnt + 1);
        arr[cnt][i] = 0;
      }
    }

    for (int i = 1; i <= n; ++i) {
      arr[cnt][i] = 0;
    }
  }
}