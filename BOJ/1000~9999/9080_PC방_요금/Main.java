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

    int ts = Integer.parseInt(br.readLine());

    for (int t = 0; t < ts; ++t) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String s = st.nextToken();
      String[] time = s.split(":");
      int curTime = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
      int useTime = Integer.parseInt(st.nextToken());
      int result = 0;

      while (useTime > 0) {
        if (curTime < 180) {
          if (useTime > 240) {
            useTime -= 480 - curTime;
            curTime = 481;
            result += 5;
          } else {
            result += (useTime + 59) / 60;
            useTime = 0;
          }
        } else if (curTime >= 1320) {
          if (useTime > 240) {
            useTime -= (1440 - curTime + 480);
            curTime = 481;
            result += 5;
          } else {
            result += (useTime + 59) / 60;
            useTime = 0;
          }
        } else {
          useTime -= 60;
          curTime += 60;
          result += 1;
        }
      }
      result *= 1000;
      bw.write(result + "\n");
    }

    bw.close();
  }
}
