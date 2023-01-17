import java.util.Scanner;
 
public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n, m;
    int y, x;
    int nextY, nextX;
    int ndy, ndx;
    int d; // 북0, 동1, 남2, 서3
    int[][] arr;
    int []dy = {-1, 0, 1, 0};
    int []dx = {0, 1, 0, -1};
    int ans = 0;
    boolean chk;
    
    n = sc.nextInt();
    m = sc.nextInt();
    y = sc.nextInt();
    x = sc.nextInt();
    d = sc.nextInt();
    arr = new int[n][m];
 
    for(int i=0; i<n; ++i){
        for(int j=0; j<m; ++j){
            arr[i][j] = sc.nextInt();        
        }
    }
    
    while(true) {
    	chk = false;
    	arr[y][x] = 2;
    	++ans;
    	
    	for(int i=1; i<=4; ++i){
            nextY = y + dy[(4 + d - i) % 4];
            nextX = x + dx[(4 + d - i) % 4];
            if(arr[nextY][nextX] == 0){
            	y = nextY;
            	x = nextX;
            	d = (4 + d - i) % 4;
            	chk = true;
                break;
            }
        }
    	if(chk) {
    		continue;
    	}
    	ndy = dy[(d + 2) % 4];
    	ndx = dx[(d + 2) % 4];
    	if(arr[y + ndy][x + ndx] == 1) {
    		break;
    	} else {
    		y += ndy;
    		x += ndx;
    		--ans;
    	}
    }
    System.out.printf("%d%n", ans);
  }
}