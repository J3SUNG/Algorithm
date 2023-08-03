import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int sum = 0;
    int one = 0;
    int two = 0;
    String result = "YES";

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; ++i) {
      int num = Integer.parseInt(st.nextToken());
      sum += num;
      one += num % 2;
      two += num / 2;
    }

    System.out.println((sum + " " + one + " " + two));

    if (sum % 3 > 0 || one > two) {
      result = "NO";
    }

    bw.write(result + "\n");
    bw.close();
  }
}