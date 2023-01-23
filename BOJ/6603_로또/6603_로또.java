import java.io.*;
import java.util.*;

public class Main {
  public static BufferedReader br;
  public static BufferedWriter bw;
  public static int n;
  public static int size = 6;
  public static int[] arr;
  public static int[] box;
  public static void main(String argc[]) throws IOException{
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    while(true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      if(n == 0) {
    	  break;
      }
      arr = new int[n];
      box = new int[6];
      for(int i=0; i<n; ++i){
        arr[i] = Integer.parseInt(st.nextToken());
      }
      for(int i=0; i<n; ++i){
        DFS(i, 0);
      }
      bw.write("\n");
    }
    bw.close();
  }
  public static void DFS(int index, int cnt) throws IOException{
    box[cnt] = arr[index];
    if(cnt+1 == size){
      for(int i=0; i<size; ++i){
        bw.write(box[i] + " ");
      }
      bw.write("\n");
      return;
    }
    for(int i = index+1; i<n; ++i){
      DFS(i, cnt+1);
    }
  }
}