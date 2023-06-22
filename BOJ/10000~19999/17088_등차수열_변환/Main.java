import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  static int result = 987654321;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int arr[] = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; ++i) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    if (n <= 2) {
      result = 0;
    } else {
      dfs(arr, 2, arr[0] - 1 - (arr[1] - 1), arr[1] - 1, 2);
      dfs(arr, 2, arr[0] - 1 - arr[1], arr[1], 1);
      dfs(arr, 2, arr[0] - (arr[1] - 1), arr[1] - 1, 1);

      dfs(arr, 2, arr[0] + 1 - (arr[1] - 1), arr[1] - 1, 2);
      dfs(arr, 2, arr[0] - arr[1], arr[1], 0);
      dfs(arr, 2, arr[0] - 1 - (arr[1] + 1), arr[1] + 1, 2);

      dfs(arr, 2, arr[0] + 1 - (arr[1] + 1), arr[1] + 1, 2);
      dfs(arr, 2, arr[0] + 1 - arr[1], arr[1], 1);
      dfs(arr, 2, arr[0] - (arr[1] + 1), arr[1] + 1, 1);

      result = result == 987654321 ? -1 : result;
    }

    bw.write(result + "");
    bw.close();
  }

  public static void dfs(int[] arr, int index, int num, int prev, int cnt) {
    if (arr.length == index) {
      result = Math.min(result, cnt);
      return;
    }
    if (prev - arr[index] == num) {
      dfs(arr, index + 1, num, arr[index], cnt);
    }
    if (prev - (arr[index] + 1) == num) {
      dfs(arr, index + 1, num, (arr[index] + 1), cnt + 1);
    }
    if (prev - (arr[index] - 1) == num) {
      dfs(arr, index + 1, num, (arr[index] - 1), cnt + 1);
    }
  }
}
