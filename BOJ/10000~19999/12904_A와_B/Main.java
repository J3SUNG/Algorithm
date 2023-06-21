import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String a = br.readLine();
    String b = br.readLine();
    int aLen = a.length() - 1;
    int bs = 0;
    int be = b.length() - 1;
    boolean bc = false;
    
    while (true) {
      if (aLen == (be - bs)) {
        String compare = b.substring(bs, be + 1);
        if (bc) {
          StringBuffer sb = new StringBuffer(compare);
          compare = sb.reverse().toString();
        }
        if (a.equals(compare)) {
          bw.write("1");
        } else {
          bw.write("0");
        }
        break;
      }
      
      if (bc) {
        if (b.charAt(bs) == 'B') {
          bc = !bc;
        } 
        ++bs;
      } else {
        if (b.charAt(be) == 'B') {
          bc = !bc;
        } 
        --be;
      }
    }
    
    bw.close();
  }
}
