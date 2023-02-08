import java.io.IOException;
import java.util.Scanner;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
Scanner sc = new Scanner(System.in);
        int ts = sc.nextInt();
        int t = 0;
        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};
         
        while(t < ts) {
            ++t;
            int n = sc.nextInt();
            int d = 0;
            int[][] map = new int[n+2][n+2];
            for(int i=0; i<map.length; ++i) {
                for(int j=0; j<map.length; ++j) {
                    if(i == 0 || j == 0 || i > n || j > n ) {
                        map[i][j] = -1;
                    } else {
                        map[i][j] = 0;
                    }
                }
            }
            int cnt = 0;
            int cycle = n*n;
            int y = 1;
            int x = 1;
            while(cnt < cycle) {
                ++cnt;
                map[y][x] = cnt;
                if(map[y+dy[d]][x+dx[d]] != 0) { // 0(빈공간)이 아니면
                    d = (d + 1) % 4;
                }
                y += dy[d];
                x += dx[d];
            }
            System.out.printf("#%d%n", t);
            for(int i=1; i<=n; ++i) {
                for(int j=1; j<=n; ++j) {
                    System.out.printf("%d ", map[i][j]);
                }
                System.out.println();
            }
        }
    }
}