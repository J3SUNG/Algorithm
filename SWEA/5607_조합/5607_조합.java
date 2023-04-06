package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class test {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int r = Integer.parseInt(st.nextToken());
    long ans = 0;
    int mod = 1234567891;

    long a = 1;
    long b = 1;
    for (int i = 0; i < r; ++i) {
      a *= (n - i);
      b *= (r - i);
      a %= mod;
      b %= mod;
    }

    long b2 = 1;
    int exp = mod - 2;
    while (exp > 0) {
      if (exp % 2 > 0) {
        b2 *= b;
        b2 %= mod;
      }

      b *= b;
      b %= mod;
      exp /= 2;
    }
    ans = a * b2;
    ans %= mod;

    bw.write(ans + "\n");
    bw.close();
  }
}