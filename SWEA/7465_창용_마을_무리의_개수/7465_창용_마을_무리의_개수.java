import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class Solution {
  public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      StringTokenizer st;
      int testcase = Integer.parseInt(br.readLine());
       
      for(int t=1; t<=testcase; ++t) {
        bw.write("#" + t + " ");
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] p = new int[n+1];
        int ans = 0;
         
        for(int i=1; i<=n; ++i) {
            p[i] = i;
        }
         
        for(int i=0; i<m; ++i) { 
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
             
                int rootA = a;
                int rootB = b;
                while(rootA != p[rootA]) {
                    rootA = p[rootA];
                }
                while(rootB != p[rootB]) {
                    rootB = p[rootB];
                }
                if(rootA < rootB) {
                    p[rootA] = rootB;
                } else if (rootA > rootB) {
                    p[rootB] = rootA;                   
                }
        }
        for(int i=1; i<=n; ++i) {
            if(p[i] == i) {
                ++ans;
            }
        }
        bw.write(ans + "\n");
      }
      bw.close();
  }
}