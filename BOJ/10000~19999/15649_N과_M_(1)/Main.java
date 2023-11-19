import java.io.*;
import java.util.Scanner;

public class Main {
  public static int[] arr;
  public static boolean[] visit;
  public static int n;
  public static int m;
  public static BufferedWriter bf;

  public static void main(String argc[]) throws IOException {
    bf = new BufferedWriter(new OutputStreamWriter(System.out));
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt();
    arr = new int[m];
    visit = new boolean[n];
    for (int i = 0; i < n; ++i) {
      DFS(i, 0);
    }
    bf.close();
  }

  public static void DFS(int num, int cnt) throws IOException {
    visit[num] = true;

    arr[cnt] = num + 1;
    if (m == cnt + 1) {
      for (int i = 0; i < m; ++i) {
        bf.write(arr[i] + " ");
      }
      bf.write("\n");
      visit[num] = false;
      return;
    }

    for (int i = 0; i < n; ++i) {
      if (!visit[i]) {
        DFS(i, cnt + 1);
      }
    }

    visit[num] = false;
  }
}