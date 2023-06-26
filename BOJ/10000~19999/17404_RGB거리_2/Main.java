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
    int[][] paint = new int[n][3];
    int[][] dp1 = new int[n][3];
    int[][] dp2 = new int[n][3];
    int[][] dp3 = new int[n][3];
    int result = 987654321;

    StringTokenizer st = new StringTokenizer(br.readLine());
    dp1[0][0] = Integer.parseInt(st.nextToken());
    dp1[0][1] = 987654321;
    dp1[0][2] = 987654321;
    dp2[0][0] = 987654321;
    dp2[0][1] = Integer.parseInt(st.nextToken());
    dp2[0][2] = 987654321;
    dp3[0][0] = 987654321;
    dp3[0][1] = 987654321;
    dp3[0][2] = Integer.parseInt(st.nextToken());

    for (int i = 1; i < n - 1; ++i) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 3; ++j) {
        paint[i][j] = Integer.parseInt(st.nextToken());
        dp1[i][j] = paint[i][j] + Math.min(dp1[i - 1][(j + 1) % 3], dp1[i - 1][(j + 2) % 3]);
        dp2[i][j] = paint[i][j] + Math.min(dp2[i - 1][(j + 1) % 3], dp2[i - 1][(j + 2) % 3]);
        dp3[i][j] = paint[i][j] + Math.min(dp3[i - 1][(j + 1) % 3], dp3[i - 1][(j + 2) % 3]);
      }
    }

    st = new StringTokenizer(br.readLine());
    paint[n - 1][0] = Integer.parseInt(st.nextToken());
    paint[n - 1][1] = Integer.parseInt(st.nextToken());
    paint[n - 1][2] = Integer.parseInt(st.nextToken());

    result = Math.min(result, paint[n - 1][1] + Math.min(dp1[n - 2][0], dp1[n - 2][2]));
    result = Math.min(result, paint[n - 1][2] + Math.min(dp1[n - 2][0], dp1[n - 2][1]));
    result = Math.min(result, paint[n - 1][0] + Math.min(dp2[n - 2][1], dp2[n - 2][2]));
    result = Math.min(result, paint[n - 1][2] + Math.min(dp2[n - 2][0], dp2[n - 2][1]));
    result = Math.min(result, paint[n - 1][0] + Math.min(dp3[n - 2][1], dp3[n - 2][2]));
    result = Math.min(result, paint[n - 1][1] + Math.min(dp3[n - 2][0], dp3[n - 2][2]));

    bw.write(result + "\n");
    bw.close();
  }
}
