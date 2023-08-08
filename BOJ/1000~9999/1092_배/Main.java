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
    int[] cIndex;
    int[] box;
    int result;

    result = 0;
    n = Integer.parseInt(br.readLine());
    crane = new int[n];
    cIndex = new int[n];
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
      for (int i = 0; i < n; ++i) {
        cIndex[n - i - 1] = m - i - 1;
      }

      while (true) {
        for (int i = n - 1; i >= 0; --i) {
          while (cIndex[i] >= 0 && (box[cIndex[i]] <= 0 || crane[i] < box[cIndex[i]])) {
            --cIndex[i];
          }

          if (cIndex[i] < 0) {
            if (i == n - 1) {
              break;
            }
            continue;
          }

          if (crane[i] >= box[cIndex[i]]) {
            box[cIndex[i]] = 0;
          }
        }
        if (cIndex[n - 1] < 0) {
          break;
        }
        ++result;
      }
    }

    bw.write(result + "\n");
    bw.close();
  }
}