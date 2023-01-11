import java.util.*;
import java.io.*;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {               
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
         
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n;
            int m;
            n = sc.nextInt();
            m = sc.nextInt();
             
            int[] arr = new int[n+1]; 
            int[] cal = new int[n+1];
            int[][] dp = new int[n+1][m+1];
                 
            for (int i=1; i<=n; ++i){
                arr[i] = sc.nextInt();   
                cal[i] = sc.nextInt();
            }
             
            for(int i=1; i<dp.length; ++i){
                for(int j=1; j<dp[i].length; ++j){
                    if(cal[i] > j){
                        dp[i][j] = dp[i-1][j];   
                    } else {
                        dp[i][j] = Math.max(arr[i] + dp[i-1][j-cal[i]], dp[i-1][j]);
                    }
                }
            }
            System.out.println("#" + test_case + " " + dp[n][m]);
        }
    }
}