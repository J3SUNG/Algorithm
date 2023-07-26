import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int k = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());
    int[][] arr = new int[k][4];
    int[] result = new int[k];

    for (int i = 0; i < k; ++i) {
      st = new StringTokenizer(br.readLine());
      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = Integer.parseInt(st.nextToken());
      arr[i][2] = Integer.parseInt(st.nextToken());
      arr[i][3] = Integer.parseInt(st.nextToken());

      for (int j = i - 1; j >= 0; --j) {

      }
    }

    bw.write("" + "\n");
    bw.close();
  }
}