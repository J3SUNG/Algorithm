import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int x = Integer.parseInt(br.readLine()) * 10000000;
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    boolean possible = false;
    int lego1 = 0;
    int lego2 = 0;

    for (int i = 0; i < n; ++i) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(arr);

    for (int i = 0; i < n; ++i) {
      int piece1 = i;
      int left = i + 1;
      int right = n - 1;

      while (left <= right) {
        int piece2 = (left + right) / 2;
        System.out.println(piece1 + " " + piece2);
        System.out.println(arr[piece1] + " " + arr[piece2] + " " + (arr[piece1] + arr[piece2]));
        if (arr[piece1] + arr[piece2] == x) {
          if (Math.abs(arr[piece1] - arr[piece2]) >= Math.abs(arr[lego1] - arr[lego2])) {
            possible = true;
            lego1 = piece1;
            lego2 = piece2;
          }
          break;
        } else if (arr[piece1] + arr[piece2] < x) {
          left = piece2 + 1;
        } else if (arr[piece1] + arr[piece2] > x) {
          right = piece2 - 1;
        }
      }
    }

    if (possible)

    {
      bw.write("yes " + arr[lego1] + " " + arr[lego2]);
    } else {
      bw.write("danger");
    }

    bw.close();
  }
}