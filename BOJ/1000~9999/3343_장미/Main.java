import java.io.*;
import java.util.*;
public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    long n = Long.parseLong(st.nextToken());
    long a = Long.parseLong(st.nextToken());
    long b = Long.parseLong(st.nextToken());
    long c = Long.parseLong(st.nextToken());
    long d = Long.parseLong(st.nextToken());
    long result = Long.MAX_VALUE;

    long result1 = (n / a) * b;
    long mod1 = n % a;
    result1 += Math.min((mod1 + a - 1) / a * b, (mod1 + c - 1) / c * d);

    long result2 = (n / c) * d;
    long mod2 = n % c;
    result2 += Math.min((mod2 + a - 1) / a * b, (mod2 + c - 1) / c * d);

    result = Math.min(result1, result2);

    bw.write(result + "\n");
    bw.close();
  }
}