import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    long[] arr = new long[21];
    long[] next = new long[21];
    long result = 0;

    st = new StringTokenizer(br.readLine());
    int num = Integer.parseInt(st.nextToken());
    arr[num] = 1;

    for (int i = 1; i < n - 1; ++i) {
      int index;
      num = Integer.parseInt(st.nextToken());

      for (int j = 0; j <= 20; ++j) {
        if (arr[j] == 0) {
          continue;
        }

        index = j + num;
        if (index <= 20) {
          next[index] += arr[j];
        }

        index = j - num;
        if (index >= 0) {
          next[index] += arr[j];
        }
      }

      for (int j = 0; j <= 20; ++j) {
        arr[j] = next[j];
        next[j] = 0;
      }
    }

    int resultIndex = Integer.parseInt(st.nextToken());
    bw.write(arr[resultIndex] + "\n");
    bw.close();
  }
}