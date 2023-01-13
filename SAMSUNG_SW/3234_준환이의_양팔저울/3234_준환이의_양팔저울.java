import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    public static int dfs(int[] arr, int left, int right, int c, int n, int bit)
    {
        int ans = 0;
        if(right > left){
            return ans;
        }
        if(c == n){
            ++ans;
            return ans;
        }
        for(int i=0; i<n; ++i){
            if((bit & (1 << i)) == 0){
                ans += dfs(arr, left + arr[i], right, c+1, n, bit + (1 << i));
                ans += dfs(arr, left, right + arr[i], c+1, n, bit + (1 << i));
            }
        }
        return ans;
    }
    public static void main(String args[]) throws Exception
    {       
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
         
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int ans = 0;
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; ++i){
                arr[i] = sc.nextInt();
            }
            for(int i=0; i<n; ++i){
                ans += dfs(arr, arr[i], 0, 1, n, 1<<i);
            }
            System.out.printf("#%d %d%n", test_case, ans);
        }
    }
}
