import java.io.*;
import java.util.*;

public class Main {
  static boolean suc = false;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] arr = new int[13];
    int[] visit = new int[13];
    int cnt = 1;

    for (int i = 0; i < 5; ++i) {
      String s = br.readLine();
      for (int j = 0; j < 9; ++j) {
        if (s.charAt(j) == '.') {
          continue;
        } else if (s.charAt(j) == 'x') {
          arr[cnt] = 0;
          ++cnt;
        } else {
          arr[cnt] = (s.charAt(j) - 'A') + 1;
          visit[arr[cnt]] = 1;
          ++cnt;
        }
      }
    }

    dfs(arr, visit, 1);
  }

  public static void dfs(int[] arr, int[] visit, int index) {
    if (index == 13 | suc) {
      if (check(arr)) {
        print(arr);
        suc = true;
      }
      return;
    }

    if (arr[index] != 0) {
      dfs(arr, visit, index + 1);
      return;
    }

    for (int i = 0; i < 12; ++i) {
      if (visit[i + 1] == 1) {
        continue;
      }
      arr[index] = i + 1;
      visit[arr[index]] = 1;
      dfs(arr, visit, index + 1);
      visit[arr[index]] = 0;
      arr[index] = 0;
    }
  }

  public static boolean check(int[] arr) {
    if (arr[1] + arr[3] + arr[6] + arr[8] != 26) {
      return false;
    }
    if (arr[1] + arr[4] + arr[7] + arr[11] != 26) {
      return false;
    }
    if (arr[8] + arr[9] + arr[10] + arr[11] != 26) {
      return false;
    }
    if (arr[2] + arr[3] + arr[4] + arr[5] != 26) {
      return false;
    }
    if (arr[2] + arr[6] + arr[9] + arr[12] != 26) {
      return false;
    }
    if (arr[5] + arr[7] + arr[10] + arr[12] != 26) {
      return false;
    }
    return true;
  }

  public static void print(int[] arr) {
    for (int i = 0; i < 9; ++i) {
      if (i == 4) {
        System.out.print((char) (arr[1] + 'A' - 1));
      } else {
        System.out.print('.');
      }
    }
    System.out.println();

    for (int i = 0; i < 9; ++i) {
      if (i == 1) {
        System.out.print((char) (arr[2] + 'A' - 1));
      } else if (i == 3) {
        System.out.print((char) (arr[3] + 'A' - 1));
      } else if (i == 5) {
        System.out.print((char) (arr[4] + 'A' - 1));
      } else if (i == 7) {
        System.out.print((char) (arr[5] + 'A' - 1));
      } else {
        System.out.print('.');
      }
    }
    System.out.println();

    for (int i = 0; i < 9; ++i) {
      if (i == 2) {
        System.out.print((char) (arr[6] + 'A' - 1));
      } else if (i == 6) {
        System.out.print((char) (arr[7] + 'A' - 1));
      } else {
        System.out.print('.');
      }
    }
    System.out.println();

    for (int i = 0; i < 9; ++i) {
      if (i == 1) {
        System.out.print((char) (arr[8] + 'A' - 1));
      } else if (i == 3) {
        System.out.print((char) (arr[9] + 'A' - 1));
      } else if (i == 5) {
        System.out.print((char) (arr[10] + 'A' - 1));
      } else if (i == 7) {
        System.out.print((char) (arr[11] + 'A' - 1));
      } else {
        System.out.print('.');
      }
    }
    System.out.println();

    for (int i = 0; i < 9; ++i) {
      if (i == 4) {
        System.out.print((char) (arr[12] + 'A' - 1));
      } else {
        System.out.print('.');
      }
    }
    System.out.println();
  }
}