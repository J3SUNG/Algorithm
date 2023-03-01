import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    public static int dfs(int bit, int cnt, int index, int n, int[] x, int[] y, int value, int ex, int ey)
    {
        int result = 987654321;
        if(cnt == n){
         	return value + Math.abs(y[index]-ey)+Math.abs(x[index]-ex);   
        }
        for(int i=0; i<n; ++i){
         	if((bit & 1<< i) == 0){
             	result = Math.min(result, dfs(bit | 1<<i, cnt+1, i, n, x, y, value + Math.abs(y[index]-y[i]) + Math.abs(x[index]-x[i]), ex, ey));
            }
        }
        return result;
    }
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int ans = 987654321;
            int n = sc.nextInt();
            int[] x = new int[10];
            int[] y = new int[10];
        	          	
            int sx, sy, ex, ey;
            
            sy = sc.nextInt();
            sx = sc.nextInt();
            ey = sc.nextInt();
            ex = sc.nextInt();
          	for(int i=0; i<n; ++i){
                y[i] = sc.nextInt();
                x[i] = sc.nextInt();
          	}
            
            for(int i=0; i<n; ++i){
             	ans = Math.min(ans, dfs(1<<i, 1, i, n, x, y, Math.abs(sy-y[i]) + Math.abs(sx-x[i]), ex, ey));
            }
            System.out.printf("#%d %d%n", test_case, ans);
		}
	}
}