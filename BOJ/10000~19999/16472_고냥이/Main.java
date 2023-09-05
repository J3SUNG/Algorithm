import java.util.*;
import java.io.*;

public class Main {
  static BufferedReader br;
  static BufferedWriter bw;
  static StringTokenizer st;
  static String s;
  static int n;
  static int result;
  static int[] arr;

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

    n = Integer.parseInt(br.readLine());
    s = br.readLine();
    result = 0;
    arr = new int[26];
  }

  public static void print() throws Exception {
    bw.write(result + "\n");
    bw.close();
  }

  public static void calc() throws Exception {
    int left = 0;
    int right = 0;
    int cnt = 1;
    ++arr[s.charAt(right) - 'a'];

    while (right < s.length() - 1) {
      ++right;
      if (arr[s.charAt(right) - 'a'] == 0) {
        ++cnt;
      }
      ++arr[s.charAt(right) - 'a'];

      while (cnt > n && left < right) {
        --arr[s.charAt(left) - 'a'];
        if (arr[s.charAt(left) - 'a'] == 0) {
          --cnt;
        }
        ++left;
      }
      result = Math.max(result, right - left + 1);
    }
  }
}