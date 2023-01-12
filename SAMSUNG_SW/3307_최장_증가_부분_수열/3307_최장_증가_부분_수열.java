import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {       
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
         
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N;
            int ans = 0;
            N= sc.nextInt();
            int[] arr = new int[N];
            int[] dp = new int[N];
            for(int i=0; i<N; ++i){
                arr[i] = sc.nextInt();
            }
            for(int i=0; i<N; ++i){
                dp[i] = Math.max(dp[i], 1);
                for(int j=i; j<N; ++j){
                       if(arr[j] > arr[i]){
                            dp[j] = Math.max(dp[j], dp[i] + 1);   
                       }
                }
            }
            for(int i=0; i<N; ++i){
                ans = Math.max(ans, dp[i]);
            }
            System.out.println("#" + test_case + " " + ans);
        }
    }
}