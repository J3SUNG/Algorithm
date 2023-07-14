import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int k = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int result = 0;
    boolean isPrime = true;
    ArrayList<Integer> al = new ArrayList<>();
    int[] arr = new int[100001];

    for (int i = 2; i < Math.pow(10, k); ++i) {
      isPrime = true;
      for (int j = 0; j < al.size(); ++j) {
        if (i % al.get(j) == 0) {
          isPrime = false;
          break;
        }
      }

      if (isPrime) {
        al.add(i);
      }
    }

    for (int i = 0; i < al.size(); ++i) {
      for (int j = i + 1; j < al.size(); ++j) {
        int add = al.get(i) + al.get(j);

        if (add >= 100000) {
          break;
        }

        arr[add] = 1;
      }
    }

    for (int i = 0; i < al.size(); ++i) {
      for (int j = i; j < al.size(); ++j) {
        long mul = (long) al.get(i) * (long) al.get(j);

        if (mul < 100_000) {
          arr[(int) mul] |= 2;
        }
      }
    }

    for (int i = (int) Math.pow(10, k - 1); i < Math.pow(10, k); ++i) {
      int bit = 0;
      int num = i;
      int div = i;

      if ((arr[i] & 1) == 0) {
        continue;
      }

      while (div % m == 0) {
        div /= m;
      }

      if ((arr[div] & 2) != 0) {
        arr[i] = 7;
      } else {
        continue;
      }

      for (int j = 0; j < k; ++j) {
        if ((bit & (1 << (num % 10))) != 0) {
          bit = 0;
          break;
        }

        bit |= (1 << (num % 10));
        num /= 10;
      }

      result = bit != 0 ? result + 1 : result;
    }

    bw.write(result + "\n");
    bw.close();
  }
}