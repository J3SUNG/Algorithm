import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    Stack<Long> stack = new Stack<>();
    long max = 0;
    long result = 0;

    for (int i = 0; i < n; ++i) {
      long num = Long.parseLong(br.readLine());
      max = Math.max(num, max);

      if (stack.isEmpty()) {
        stack.push(num);
      } else {
        if (stack.peek() < num) {
          result += num - stack.pop();
          stack.push(num);
        } else if (stack.peek() > num) {
          stack.pop();
          stack.add(num);
        }
      }
    }
    while (!stack.isEmpty()) {
      result += max - stack.pop();
    }

    bw.write(result + "");
    bw.close();
  }
}