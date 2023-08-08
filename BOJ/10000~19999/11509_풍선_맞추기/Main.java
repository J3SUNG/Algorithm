import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = null;

    int result = 0;
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[1000002];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; ++i) {
      int num = Integer.parseInt(st.nextToken());
      if (arr[num + 1] > 0) {
        --arr[num + 1];
      }
      ++arr[num];
    }

    for (int i = 0; i < arr.length; ++i) {
      result = arr[i] > 0 ? result + arr[i] : result;
    }

    bw.write(result + "\n");
    bw.close();
  }
}