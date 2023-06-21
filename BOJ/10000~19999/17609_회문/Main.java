import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  static int result;
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Integer.parseInt(br.readLine());
    String s;

    for (int ts = 0; ts < t; ++ts) {
      result = 2;
      s = br.readLine();

      check(s, 0, s.length() - 1, 0);
      bw.write(result + "\n");
    }
    bw.close();
  }

  public static void check(String s, int left, int right, int type) {
    if (left >= right) {
      result = type;
      return;
    }

    if (s.charAt(left) != s.charAt(right)) {
      if (type == 0) {
        check(s, left + 1, right, 1);
        if (result == 2) {
          check(s, left, right - 1, 1);
        }
        return;
      } else {
        result = 2;
        return;
      }
    }
    
    if (s.charAt(left) == s.charAt(right)) {
      check(s, left + 1, right - 1, type);
    }
  }
}
