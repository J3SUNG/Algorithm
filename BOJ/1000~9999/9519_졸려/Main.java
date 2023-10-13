import java.util.*;
import java.io.*;

public class Main {
  static BufferedReader br;
  static BufferedWriter bw;
  static StringTokenizer st;
  static String s;
  static String result;
  static int n;

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
    result = s;
  }

  public static void print() throws Exception {
    bw.write(result + "\n");
    bw.close();
  }

  public static void calc() throws Exception {
    int cnt = count(s);

    for (int i = 0; i < cnt - (n % cnt); ++i) {
      s = func(s);
    }

    result = s;
  }

  public static int count(String s) throws Exception {
    int cnt = 0;
    String nextStr = s;
    while (true) {
      String temp = "";

      for (int i = 0; i < nextStr.length(); ++i) {
        if (i % 2 == 0) {
          temp += nextStr.charAt((i / 2));
        } else {
          temp += nextStr.charAt(nextStr.length() - 1 - (i / 2));
        }
      }

      nextStr = temp;
      ++cnt;

      if (temp.equals(s)) {
        break;
      }
    }

    return cnt;
  }

  public static String func(String s) throws Exception {
    String temp = "";
    for (int i = 0; i < s.length(); ++i) {
      if (i % 2 == 0) {
        temp += s.charAt((i / 2));
      } else {
        temp += s.charAt(s.length() - 1 - (i / 2));
      }
    }

    return temp;
  }
}