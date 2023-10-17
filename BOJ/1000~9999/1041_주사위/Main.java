import java.util.*;
import java.io.*;

public class Main {
  static BufferedReader br;
  static BufferedWriter bw;
  static StringTokenizer st;
  static int[] arr;
  static long n;
  static long result;
  static int MAX = 150;

  public static void main(String[] args) throws Exception {
    simulation();
  }

  public static void simulation() throws Exception {
    init();
    calc();
    print();
  }

  public static void init() throws Exception {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    arr = new int[6];
    n = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());

    arr[0] = Integer.parseInt(st.nextToken());
    arr[1] = Integer.parseInt(st.nextToken());
    arr[4] = Integer.parseInt(st.nextToken());
    arr[5] = Integer.parseInt(st.nextToken());
    arr[3] = Integer.parseInt(st.nextToken());
    arr[2] = Integer.parseInt(st.nextToken());
  }

  public static void print() throws Exception {
    bw.write(result + "\n");
    bw.close();
  }

  public static void calc() throws Exception {
    int maxValue = 0;
    int min0 = 0;
    int min1 = MAX;
    int min2 = MAX;
    int min3 = MAX;
    for (int i = 0; i < 6; ++i) {
      maxValue = Math.max(maxValue, arr[i]);
      min0 += arr[i];
      min1 = Math.min(min1, arr[i]);
    }
    min0 -= maxValue;

    min2 = Math.min(min2, arr[0] + arr[1]);
    min2 = Math.min(min2, arr[0] + arr[3]);
    min2 = Math.min(min2, arr[0] + arr[4]);
    min2 = Math.min(min2, arr[0] + arr[5]);
    min2 = Math.min(min2, arr[1] + arr[2]);
    min2 = Math.min(min2, arr[1] + arr[4]);
    min2 = Math.min(min2, arr[1] + arr[5]);
    min2 = Math.min(min2, arr[2] + arr[3]);
    min2 = Math.min(min2, arr[2] + arr[4]);
    min2 = Math.min(min2, arr[2] + arr[5]);
    min2 = Math.min(min2, arr[3] + arr[4]);
    min2 = Math.min(min2, arr[3] + arr[5]);

    min3 = Math.min(min3, arr[0] + arr[1] + arr[5]);
    min3 = Math.min(min3, arr[0] + arr[1] + arr[4]);
    min3 = Math.min(min3, arr[0] + arr[3] + arr[4]);
    min3 = Math.min(min3, arr[0] + arr[3] + arr[5]);
    min3 = Math.min(min3, arr[2] + arr[1] + arr[5]);
    min3 = Math.min(min3, arr[2] + arr[1] + arr[4]);
    min3 = Math.min(min3, arr[2] + arr[3] + arr[4]);
    min3 = Math.min(min3, arr[2] + arr[3] + arr[5]);

    if (n == 1) {
      result = min0;
    } else {
      result = min3 * 4 + min2 * 4 + min1 * (n - 2) * 4 + min2 * (n - 2) * 8 + min1 * (n - 2) * (n - 2) * 5;
    }
  }
}