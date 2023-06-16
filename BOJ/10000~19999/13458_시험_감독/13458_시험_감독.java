import java.util.*;
import java.io.*;

public class Main {
  public static void main(String argc[]) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int a = Integer.parseInt(br.readLine());
    int b, c;
    long ans = a;
    int[] perNum = new int[a];

    st = new StringTokenizer(br.readLine());
    for(int i=0; i<a; ++i){
      perNum[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    b = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    for(int i=0; i<a; ++i){
      perNum[i] -= b;
      if(perNum[i] <= 0){
        continue;
      }
      ans += (perNum[i] + c - 1) / c;
    }
    System.out.printf("%d%n", ans);
  }
}