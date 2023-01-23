import java.util.*;
import java.io.*;

public class Main {
  public static int n;
  public static int m;
  public static int v;
  public static boolean [][] arr;
  public static boolean[] visit;
  public static void main(String args[]) throws Exception{
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int a, b;
    int num;
    Queue<Integer> queue = new LinkedList<>();
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    v = Integer.parseInt(st.nextToken());
    visit = new boolean[n+1];
    arr = new boolean[n+1][n+1];

    for(int i=0; i<m; ++i){
      st = new StringTokenizer(br.readLine());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      
      arr[a][b] = true;
      arr[b][a] = true;
    }

    visit[v] = true;
    DFS(v);
    System.out.printf("%n");
    
    Arrays.fill(visit, false);
    visit[v] = true;
    queue.add(v);
    while(queue.size() != 0){
      num = queue.poll();
      System.out.printf("%d ", num);

      for(int i=0; i<n+1; ++i){
        if(arr[num][i] & !visit[i]){
          visit[i] = true;
          queue.add(i);
        }
      }
    }
  }

  public static void DFS(int num){
    System.out.printf("%d ", num);
    for(int i=0; i<n+1; ++i){
      if(arr[num][i] && !visit[i]){
        visit[i] = true;
        DFS(i);
      }
    }
  }
}