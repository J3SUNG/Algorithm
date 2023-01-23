import java.util.*;
import java.io.*;

public class Main{
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Queue<Integer> queue = new LinkedList<>();
    
    int n = Integer.parseInt(br.readLine());
    int num;
    int back = -1;
    for(int i=0; i<n; ++i){
      StringTokenizer st = new StringTokenizer(br.readLine());
      String s = st.nextToken();
      if("push".equals(s)){
          num = Integer.parseInt(st.nextToken());
          back = num;
          queue.add(num);
      } else if("pop".equals(s)){
          if(queue.size() != 0) {
            System.out.println(queue.poll());
          } else {
            back = -1;
            System.out.println(-1);
          }
      } else if("size".equals(s)){
          System.out.println(queue.size());
      } else if("empty".equals(s)){
          if(queue.size() == 0){
              System.out.println(1);    
          } else {
              System.out.println(0);
          }
      } else if("front".equals(s)){
        if(queue.size() != 0) {
          System.out.println(queue.peek());
        } else {
          System.out.println(-1);
        }
      } else if("back".equals(s)){
        if(queue.size() != 0) {
          System.out.println(back);
        } else {
          System.out.println(-1);
        }
      }
    }
  }
}