import java.awt.Point;
import java.util.*;
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
            int n = sc.nextInt();
            int y, x;
            int[][] arr = new int[102][102];
            int[][] dp = new int[102][102];
            String s = sc.nextLine();
            int[] moveX = {0, 1, 0, -1};
            int[] moveY = {1, 0, -1, 0};
            boolean chk = false;
            Point p;
            Queue<Point> queue = new LinkedList<>();
            
            for(int i=0; i<102; ++i){
            	Arrays.fill(arr[i], -1); 
                Arrays.fill(dp[i], 99999); 
            } 
             
            for(int i=1; i<=n; ++i){
                s = sc.nextLine();
                for(int j=1; j<=n; ++j){
                    arr[i][j] = Integer.parseInt(s.substring(j-1,j));
                }
                dp[1][1] = arr[1][1];
                queue.add(new Point(1, 1));   
            }
             
            while(!queue.isEmpty()){
                p = queue.poll();
                y = p.x;
                x = p.y;
                for(int i=0; i<4; ++i){
                    if(arr[y+moveY[i]][x+moveX[i]] == -1){
                     	continue;   
                    }
                    if(dp[y+moveY[i]][x+moveX[i]] > arr[y+moveY[i]][x+moveX[i]] + dp[y][x]){
                        dp[y+moveY[i]][x+moveX[i]] = arr[y+moveY[i]][x+moveX[i]] + dp[y][x];
                        if(y+moveY[i] == n && x+moveX[i] == n ){
                            continue;
                        }
                        queue.add(new Point(y+moveY[i], x+moveX[i]));   
                    }
                }
            }
            System.out.printf("#%d %d%n", test_case, dp[n][n]);
        }
    }
}