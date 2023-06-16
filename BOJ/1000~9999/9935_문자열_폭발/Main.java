import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String str = br.readLine();
    String word = br.readLine();
    char[] result = new char[str.length()];
    int index = 0;
    int len = word.length();
    boolean chk = false;

    for (int i = 0; i < str.length(); ++i) {
      result[index] = str.charAt(i);
      if (index >= len - 1) {
        for (int j = 0; j < len; ++j) {
          chk = true;
          if (result[index - j] != word.charAt(len - 1 - j)) {
            chk = false;
            break;
          }
        }
        if (chk) {
          index -= len;
        } else {
        }
      } 
      ++index;
    }
    
    if (index == 0) {
      bw.write("FRULA");
    }
    
    for (int i = 0; i < index; ++i) {
      bw.write(result[i]);
    }
    
    bw.close();
  }
}