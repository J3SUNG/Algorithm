import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[] arr = new int[n + 1];
    int[] turn = new int[m];
    int size;
    int num;
    int result = 0;

    st = new StringTokenizer(br.readLine());
    size = Integer.parseInt(st.nextToken());

    for (int i = 0; i <= n; ++i) {
      arr[i] = i;
    }

    for (int i = 0; i < size; ++i) {
      num = Integer.parseInt(st.nextToken());
      arr[num] = 0;
    }

    for (int i = 0; i < m; ++i) {
      st = new StringTokenizer(br.readLine());
      size = Integer.parseInt(st.nextToken());
      int[] temp = new int[size + 1];

      int parent = 100;
      for (int j = 1; j <= size; ++j) {
        temp[j] = Integer.parseInt(st.nextToken());
        parent = Math.min(parent, check(temp[j], arr, false, 0));
      }

      turn[i] = temp[1];
      for (int j = 1; j <= size; ++j) {
        check(temp[j], arr, true, parent);
      }
    }

    for (int i = 0; i < m; ++i) {
      if (check(turn[i], arr, false, 0) != 0) {
        ++result;
      }
    }

    bw.write(result + "\n");
    bw.close();
  }

  static public int check(int num, int[] arr, boolean toggle, int change) {
    if (num == arr[num] || num == 0) {
      if (toggle) {
        arr[num] = change;
      }
      return arr[num];
    }
    int value = check(arr[num], arr, toggle, change);
    arr[num] = value;
    return value;
  }
}
