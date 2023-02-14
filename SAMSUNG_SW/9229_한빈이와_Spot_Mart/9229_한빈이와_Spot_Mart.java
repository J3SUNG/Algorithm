import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
 
class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for(int tc=0; tc<t; ++tc) {
            int ans = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; ++i) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for(int i=0; i<n; ++i) {
                for(int j=i+1; j<n; ++j) {
                    if(m >= arr[i] + arr[j]) {
                        ans = Math.max(ans, arr[i] + arr[j]);
                    }
                }
            }
            ans = ans==0?-1:ans;
            bw.write("#" + (tc+1) + " " + ans + "\n");
        }
        bw.close();
    }
}