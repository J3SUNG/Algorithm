import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br;
  static BufferedWriter bw;
  static int[][] arr;
  static int n;

  public static void main(String[] args) throws Exception {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
    n = Integer.parseInt(br.readLine());
    arr = new int[27][2];

    for (int i = 0; i < n; ++i) {
      String str = br.readLine();
      int a = str.charAt(0) - 'A';
      int b = str.charAt(2) - 'A';
      int c = str.charAt(4) - 'A';

      if (b == -19) {
        b = 26;
      }
      if (c == -19) {
        c = 26;
      }
      arr[a][0] = b;
      arr[a][1] = c;
    }

    preorder(0);
    bw.write("\n");
    inorder(0);
    bw.write("\n");
    postorder(0);
    bw.write("\n");

    bw.close();
  }

  public static void preorder(int index) throws Exception {
    bw.write(index + 'A');
    if (arr[index][0] != 26) {
      preorder(arr[index][0]);
    }
    if (arr[index][1] != 26) {
      preorder(arr[index][1]);
    }
  }

  public static void inorder(int index) throws Exception {
    if (arr[index][0] != 26) {
      inorder(arr[index][0]);
    }
    bw.write(index + 'A');
    if (arr[index][1] != 26) {
      inorder(arr[index][1]);
    }
  }

  public static void postorder(int index) throws Exception {
    if (arr[index][0] != 26) {
      postorder(arr[index][0]);
    }
    if (arr[index][1] != 26) {
      postorder(arr[index][1]);
    }
    bw.write(index + 'A');
  }
}