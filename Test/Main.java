import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  static long N, M;
  static long[] time;
  static long answer = 1_000_000_000L * 1_000_000_000L;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;
    st = new StringTokenizer(br.readLine());
    N = Long.parseLong(st.nextToken());
    M = Long.parseLong(st.nextToken());
    time = new long[(int) N];

    for (int i = 0; i < N; i++) {
      time[i] = Long.parseLong(br.readLine());
    }

    long start = 1;
    long end = 1_000_000_000L * 1_000_000_000L;
    while (start <= end) {
      long mid = (start + end) / 2;
      long temp = M;
      
      for (int i = 0; i < N; i++) {
        temp -= mid / time[i];
        if (temp <= 0) {
          break;
        }
      }

      if (temp <= 0) {
        end = mid - 1;
        answer = Math.min(answer, mid);
      } else {
        start = mid + 1;
      }
    }

    System.out.println(answer);
  }
}