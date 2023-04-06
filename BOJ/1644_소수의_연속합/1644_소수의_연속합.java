import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  static ArrayList<Integer> prime;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int ans = 0;
    int n = Integer.parseInt(st.nextToken());
    prime = new ArrayList<>();

    for (int i = 2; i <= n; ++i) {
      IsPrime(i);
    }

    if (n == 1) {
      bw.write(ans + "");
      bw.close();
      return;
    }

    int left = 0;
    int right = 0;
    int value = prime.get(0);

    while (left <= right) {
      if (prime.size() <= left) {
        break;
      }
      if (value < n) {
        ++right;
        if (prime.size() <= right) {
          break;
        }
        value += prime.get(right);
      } else if (value > n) {
        value -= prime.get(left);
        ++left;
      } else if (value == n) {
        ++ans;
        value -= prime.get(left);
        ++left;
        ++right;
        if (prime.size() <= right) {
          break;
        }
        value += prime.get(right);
      }
    }

    bw.write(ans + "");
    bw.close();
  }

  public static void IsPrime(int num) {
    for (int i = 2; i <= Math.sqrt(num); ++i) {
      if (num % i == 0) {
        return;
      }
    }

    prime.add(num);
  }
}