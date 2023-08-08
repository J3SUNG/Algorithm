import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = null;

    int n;
    int m;
    int[] crane;
    int[] box;
    int result;

    result = 0;
    n = Integer.parseInt(br.readLine());
    crane = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; ++i) {
      crane[i] = Integer.parseInt(st.nextToken());
    }

    m = Integer.parseInt(br.readLine());
    box = new int[m];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; ++i) {
      box[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(crane);
    Arrays.sort(box);

    if (crane[n - 1] < box[m - 1]) {
      result = -1;
    } else {
      int index = m - 1;
      while (true) {
        ++result;
        for (int i = n - 1; i >= 0; --i) {
          if (index < 0) {
            break;
          }
          if (crane[i] >= box[index]) {
            --index;
          }
        }

        if (index < 0) {
          break;
        }
      }
    }

    bw.write(result + "\n");
    bw.close();
  }
}