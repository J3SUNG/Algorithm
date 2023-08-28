import java.util.*;
import java.io.*;

public class Main {
  static BufferedReader br;
  static BufferedWriter bw;
  static StringTokenizer st;
  static int n;
  static Stack<Integer> stack;
  static int result = 0;

  public static void main(String[] args) throws Exception {
    simulation();
  }

  public static void init() throws Exception {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
    st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    stack = new Stack<>();
  }

  public static void printResult() throws Exception {
    bw.write(result + "");
    bw.close();
  }

  public static void countBuilding() throws Exception {
    for (int i = 0; i < n; ++i) {
      st = new StringTokenizer(br.readLine());
      int num = Integer.parseInt(st.nextToken());
      num = Integer.parseInt(st.nextToken());

      if (!stack.empty()) {
        while (!stack.isEmpty() && num < stack.peek()) {
          ++result;
          stack.pop();
        }
        if (!stack.empty() && num == stack.peek()) {
          continue;
        }
      }
      if (num == 0) {
        continue;
      }
      stack.push(num);

    }

    while (!stack.empty()) {
      ++result;
      stack.pop();
    }
  }

  public static void simulation() throws Exception {
    init();
    countBuilding();
    printResult();
  }
}