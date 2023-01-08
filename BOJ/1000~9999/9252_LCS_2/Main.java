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
    
    int y = a.length();
  	int x = b.length();
  	if(arr[y][x] > 0) {
      while(x >= 1 && y >= 1) {
      	if(arr[y-1][x] == arr[y][x]) {
      		--y;
      	} else if (arr[y][x-1] == arr[y][x]) {
      		--x;
      	} else {
    			--y;
    			--x;
    			ans += a.charAt(y);
      	}
      }
  	}
    
    bw.write(arr[a.length()][b.length()] + "\n");
    for(int i=ans.length()-1; i>=0; --i) {
    	bw.write(ans.charAt(i) + "");
    }
      
  	bw.close();
  }
}