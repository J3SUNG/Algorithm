import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int result = 0;
    ArrayList<Integer> al = new ArrayList<>();

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; ++i) {
      int num = Integer.parseInt(st.nextToken());
      if (num == 0) {
        continue;
      }
      al.add(num);
    }

    int mulMax = 0;
    int addMax = 0;
    for (int i = 0; i < al.size(); ++i) {
      int mulCnt = 0;
      int addCnt = 0;

      int num = al.get(i);
      while (num > 1) {
        if (num % 2 == 0) {
          num /= 2;
          ++mulCnt;
        } else {
          --num;
          ++addCnt;
        }
      }
      ++addCnt;

      mulMax = Math.max(mulMax, mulCnt);
      addMax += addCnt;
    }

    result = mulMax + addMax;

    bw.write(result + "\n");
    bw.close();
  }
}