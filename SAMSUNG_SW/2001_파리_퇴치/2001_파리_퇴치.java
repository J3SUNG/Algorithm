import java.util.Scanner;
 
class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ts = sc.nextInt();
        for(int t=0; t<ts; ++t) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int ans = 0;
            int[][] map = new int[n+1][n+1];
            for(int i=1; i<=n; ++i) {
                for(int j=1; j<=n; ++j) {
                    int num = sc.nextInt();
                    map[i][j] = num + map[i-1][j] + map[i][j-1] - map[i-1][j-1];
                }
            }
            for(int i=m; i<=n; ++i) {
                for(int j=m; j<=n; ++j) {
                    ans = Math.max(ans, map[i][j] - map[i-m][j] - map[i][j-m] + map[i-m][j-m]); 
                }
            }
            System.out.printf("#%d %d %n", t+1, ans);
        }
    }
}