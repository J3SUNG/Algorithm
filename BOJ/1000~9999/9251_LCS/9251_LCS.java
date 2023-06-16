import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      String ans = "";
      
      String a = br.readLine();
      String b = br.readLine();
      int[][] arr = new int[a.length()+1][b.length()+1];
      
      for(int i=1; i<=a.length(); ++i) {
      	for(int j=1; j<=b.length(); ++j) {
      		arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
      		if(a.charAt(i-1) == b.charAt(j-1)) {
      			arr[i][j] = Math.max(arr[i][j], arr[i-1][j-1] + 1);
      		}
      	}
      }
      
      bw.write(arr[a.length()][b.length()] + "\n");
    	bw.close();
  }
}