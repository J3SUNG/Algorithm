import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    int index = 0;
    int result = 0;

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; ++i) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);
    for (int i = 0; i < n; ++i) {
      int findNum = arr[i];
      int left = 0;
      int right = n - 1;
      int sum = 0;

      while (left < right) {
        sum = arr[left] + arr[right];
        if (sum == findNum) {
          if (i == left) {
            ++left;
          } else if (right == i) {
            --right;
          } else {
            ++result;
            break;
          }
        }

        if (arr[left] + arr[right] > findNum) {
          --right;
        } else if (arr[left] + arr[right] < findNum) {
          ++left;
        }
      }
    }

    bw.write(result + "\n");
    bw.close();
  }
}