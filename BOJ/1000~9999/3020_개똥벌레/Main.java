import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[] arr1 = new int[m]; 
    int[] arr2 = new int[m]; 
    int[] result = new int[m + 1];
    int minNum = 987654321;
    int cnt = 0;

    for (int i = 0; i < n; ++i) {
      int num = Integer.parseInt(br.readLine());
      if (i % 2 == 0) {
        ++arr1[num];
      } else {
        ++arr2[num];
      }
    }

    for (int i = m - 1; i > 0; --i) {
      arr1[i - 1] += arr1[i];
      arr2[i - 1] += arr2[i];
    }
    
    for (int i = 1; i < m; ++i) {
      result[i] += arr1[i];
      result[m + 1 - i] += arr2[i];
    }

    for (int i = 1; i <= m; ++i) {
      if (minNum > result[i]) {
        minNum = result[i];
        cnt = 1;
      } else if (minNum == result[i]) {
        ++cnt;
      }
    }
    
    bw.write(minNum + " " + cnt);
    bw.close();
  }
}
