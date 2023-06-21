import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  static int n;
  static int l;
  static int p;
  static int x;
  static int result;
  static int[] a;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    l = Integer.parseInt(st.nextToken());
    p = Integer.parseInt(st.nextToken());
    x = Integer.parseInt(st.nextToken());
    result = 0;
    a = new int[n];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; ++i) {
      a[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < n; ++i) {
      DFS(i, a[i], a[i], a[i], 1); // index, low, high, sum, 개수
    }

    bw.write(result + "\n");
    bw.close();
  }

  public static void DFS(int index, int low, int high, int sum, int cnt) {
    if(sum >= l && sum <= p && cnt > 1 && low <= high - x) {
      ++result;
    }

    for(int i=index+1; i<n; ++i){
      DFS(i, a[i] < low ? a[i] : low, a[i] > high ? a[i] : high, sum + a[i], cnt + 1);
    }
  }
}
