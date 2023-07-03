import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  static int n;
  static boolean chk;
  static String s;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    for (int i = 0; i < n; ++i) {
      s = br.readLine();
      chk = dfs(0, 0, 0);

      if (chk) {
        bw.write("YES\n");
      } else {
        bw.write("NO\n");
      }
    }
    bw.close();
  }

  public static boolean dfs(int index, int state, int stateIndex) {
    if (index == s.length()) {
      if (stateIndex == 0) {
        return true;
      } else {
        return false;
      }
    }

    if (stateIndex == 0) {
      if (s.charAt(index) == '0') {
        return dfs(index, 0, 1);
      } else {
        return dfs(index, 1, 1);
      }
    }

    if (stateIndex == 1) {
      return dfs(index + 1, state, stateIndex + 1);
    }

    if (stateIndex == 2) {
      if (s.charAt(index) - 48 != state) {
        if (state == 0) {
          return dfs(index + 1, 0, 0);
        } else {
          return dfs(index + 1, state, stateIndex + 1);
        }
      } else {
        return false;
      }
    }

    if (stateIndex == 3) {
      if (s.charAt(index) == '0') {
        return dfs(index + 1, state, stateIndex + 1);
      } else {
        return false;
      }
    }

    if (stateIndex == 4) {
      if (s.charAt(index) == '0') {
        return dfs(index + 1, state, stateIndex);
      } else {
        return dfs(index + 1, 0, 0) || dfs(index + 1, state, stateIndex + 1);
      }
    }

    if (stateIndex == 5) {
      if (s.charAt(index) == '1') {
        return dfs(index + 1, 0, 0) || dfs(index + 1, state, stateIndex);
      } else {
        return false;
      }
    }

    return true;
  }
}