import java.util.*;

class Solution {
  public static void main(String[] args) {
    String result = solution(3, 3, 1, 2, 3, 3, 4);
    System.out.println(result);
  }

  public static String solution(int n, int m, int x, int y, int r, int c, int k) {
    String answer = "";

    int dist = Math.abs(x - r) + Math.abs(y - c);
    if (dist > k || (k - dist) % 2 != 0) {
      return "impossible";
    }

    int[] my = { 0, -1, 1, 0 };
    int[] mx = { 1, 0, 0, -1 };

    while (k > 0) {
      System.out.println(k);
      for (int i = 0; i < 4; ++i) {
        int nx = x + mx[i];
        int ny = y + my[i];

        if (nx <= 0 || nx > n || ny <= 0 || ny > m) {
          continue;
        }

        if (k < Math.abs(nx - r) + Math.abs(ny - c)) {
          continue;
        }

        if (i == 0) {
          answer += "d";
        } else if (i == 1) {
          answer += "l";
        } else if (i == 2) {
          answer += "r";
        } else if (i == 3) {
          answer += "u";
        }

        x = nx;
        y = ny;
        --k;
        break;
      }
    }

    return answer;
  }
}