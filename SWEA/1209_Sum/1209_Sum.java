import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {       
        Scanner sc = new Scanner(System.in);
        int T = 10;
         
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int ans = 0;
            int sum1;
            int sum2;
            int sum3 = 0;
            int sum4 = 0;
            int n = sc.nextInt();
            int[][] arr = new int[101][101];
            for(int i=1; i<=100; ++i){
                for(int j=1; j<=100; ++j){
                    arr[i][j] = sc.nextInt();
                }
            }
            for(int i=1; i<=100; ++i){
                sum1 = 0;
                sum2 = 0;
                for(int j=1; j<=100; ++j){
                    sum1 += arr[i][j]; 
                    sum2 += arr[j][i]; 
                }
                sum3 += arr[i][i];
                sum4 += arr[i][100-i];
                ans = Math.max(ans, sum1);
                ans = Math.max(ans, sum2);
            }
            ans = Math.max(ans, sum3);
            ans = Math.max(ans, sum4);
            System.out.printf("#%d %d%n",test_case, ans);
        }
    }
}
