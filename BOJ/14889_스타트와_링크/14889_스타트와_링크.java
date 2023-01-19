import java.util.*;
import java.io.*;
 
public class Main {
  static int n;
  static int[][] arr;
  static boolean[] team;
  static int ans = Integer.MAX_VALUE;
    
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
    n = Integer.parseInt(br.readLine());
      
    arr = new int[n][n];
    team = new boolean[n];
      
    for(int i=0; i<n; ++i){
      StringTokenizer str = new StringTokenizer(br.readLine());
      for(int j=0; j<n; ++j){
        arr[i][j] = Integer.parseInt(str.nextToken());
      }
    }
      
    dfs(0, 0);
 
    System.out.println(ans);
  }
  static void dfs(int index, int cnt) {
    if(n / 2 == cnt){
      diff();
      return;
    }
    
    for(int i=index; i<n; ++i){
      team[i] = true;
      dfs(i+1, cnt+1);
      team[i] = false;
    }
  }
  
  static void diff() {
    int a = 0;
    int b = 0;
  
    for(int i=0; i<n-1; ++i){
      for(int j=i+1; j<n; ++j){
        if(team[i] == true && team[j] == true){
          a += arr[i][j];
          a += arr[j][i];
        } else if (team[i] == false && team[j] == false){
          b += arr[i][j];
          b += arr[j][i];
        }
      }
    }
    ans = Math.min(ans, Math.abs(a-b));
  }
}