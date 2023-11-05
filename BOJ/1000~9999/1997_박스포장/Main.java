import java.util.*;
import java.io.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static StringTokenizer st = null;
  static int n, w, b;
  static int h;
  static ArrayList<Integer> result;
  static int[][] map;
  static int[] arr;
  static int[] start;
  static int[] end;
  static int min;
  static int max;
  static int height;
  static boolean full;

  public static void main(String[] args) throws Exception {
    simulation();
  }

  public static void simulation() throws Exception {
    init();
    calc();
    print();
  }

  public static void init() throws Exception {
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    w = Integer.parseInt(st.nextToken());
    b = Integer.parseInt(st.nextToken());
    result = new ArrayList<>();
    arr = new int[w];
    start = new int[w];
    end = new int[w];
    min = 0;
    max = 0;
    full = false;
  }

  public static void print() throws Exception {
    for (int i = 0; i < result.size(); ++i) {
      bw.write(result.get(i) + " ");
    }
    bw.close();
  }

  public static void calc() throws Exception {
    for (int i = 0; i < n; ++i) {
      int h = Integer.parseInt(br.readLine());
      min = Integer.MAX_VALUE;
      map = new int[h][w];

      height += h;
      for (int j = 0; j < w; ++j) {
        start[j] = -1;
        end[j] = 0;
      }

      for (int j = 0; j < h; ++j) {
        String s = br.readLine();
        for (int k = 0; k < s.length(); ++k) {
          map[j][k] = s.charAt(k) == '.' ? 0 : 1;
        }
      }

      for (int j = 0; j < w; ++j) {
        for (int k = h - 1; k >= 0; --k) {
          if (map[k][j] == 1) {
            if (start[j] == -1) {
              start[j] = h - k;
            }
            end[j] = h - k;
          }
        }
      }

      for (int j = 0; j < w; ++j) {
        System.out.print(arr[j] + " ");
      }
      System.out.println("ARR");
      for (int j = 0; j < w; ++j) {
        System.out.print(start[j] + " ");
      }
      System.out.println("START");
      for (int j = 0; j < w; ++j) {
        System.out.print(end[j] + " ");
      }
      System.out.println("END");

      for (int j = 0; j < w; ++j) {
        System.out.println(arr[j] + " " + end[j] + " " + b);
        if (arr[j] + end[j] > b) {
          System.out.println("FULL");
          full = true;
          max = 0;
          for (int k = 0; k < w; ++k) {
            max = Math.max(max, arr[k]);
            arr[k] = end[k];
          }
          result.add(max);
          break;
        }
      }

      if (i == n - 1) {
        max = 0;
        for (int j = 0; j < w; ++j) {
          max = Math.max(max, arr[j]);
        }
        result.add(max);
        break;
      }

      if (full) {
        full = false;
        continue;
      }

      for (int j = 0; j < w; ++j) {
        arr[j] += end[j];
      }

    }
  }
}