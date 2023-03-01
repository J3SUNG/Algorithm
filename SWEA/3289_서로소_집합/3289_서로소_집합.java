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
        int[] arr = new int[n+1];
         
        for(int i=1; i<=n; ++i) {
            arr[i] = i;
        }
         
        for(int i=0; i<m; ++i) {
            st = new StringTokenizer(br.readLine());
            int cal = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
             
            if(cal == 0) {
                int rootA = a;
                int rootB = b;
                while(rootA != arr[rootA]) {
                    rootA = arr[rootA];
                }
                while(rootB != arr[rootB]) {
                    rootB = arr[rootB];
                }
                if(rootA < rootB) {
                    arr[rootA] = rootB;
                } else if (rootA > rootB) {
                    arr[rootB] = rootA;
                     
                }
            } else if (cal == 1) {
                int rootA = a;
                int rootB = b;
                while(rootA != arr[rootA]) {
                    rootA = arr[rootA];
                }
                while(rootB != arr[rootB]) {
                    rootB = arr[rootB];
                }
                if(rootA == rootB) {
                    bw.write("1");
                } else {
                    bw.write("0");
                }
            }
        }
        bw.write("\n");
      }
      bw.close();
  }
}