import java.util.*;
import java.io.*;

public class Main {
  public static int n;
  public static int m;
  public static int[][] arr;
  public static int[][] arrTmp;
  public static int[][] cctv = {{-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}};
  public static int[] cctvD;
  public static int cctvNum;
  public static int ans;
  public static int[] dy = {0, 1, 0, -1};
  public static int[] dx = {1, 0, -1, 0};
  public static void main(String argc[]){
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt();
    arr = new int[n][m];
    arrTmp = new int[n][m];
    ans = n*m;
    cctvNum = 0;
    
    for(int i=0; i<n; ++i) {
    	for(int j=0; j<m; ++j) {
    		arr[i][j] = sc.nextInt();
    		if(arr[i][j] != 0 && arr[i][j] != 6) {
    			cctv[cctvNum][0] = i;
    			cctv[cctvNum][1] = j;
    			++cctvNum;
    		}
    	}
    }
    cctvD = new int[cctvNum];
    DFS(0);    
    
    System.out.printf("%d", ans);
  }
  public static void DFS(int index) {
  	if(index == cctvNum) {
  		for(int i=0; i<n; ++i) {
      	for(int j=0; j<m; ++j) {
      		arrTmp[i][j] = arr[i][j];
      	}
  		}
  		drawMap();
  		return;
  	}
  	int y = cctv[index][0];
  	int x = cctv[index][1];
  	switch(arr[y][x]) {
	  	case 1:
	  	case 3:
	  	case 4:
	  		cctvD[index] = 3;
	  		DFS(index + 1);
	  		cctvD[index] = 2;
	  		DFS(index + 1);
	  	case 2:  		
	  		cctvD[index] = 1;
	  		DFS(index + 1);
	  	case 5:
	  		cctvD[index] = 0;
	  		DFS(index + 1);
	  		break; 		
  	}
  }
  public static void drawMap() {
  	int y, x;
  	int num;
  	int sum = 0;
  	for(int i=0; i<cctvNum; ++i) {
  		y = cctv[i][0];
  		x = cctv[i][1];
  		num = arr[y][x];
  		switch(num) {
  			case 1:
  				go(y, x, cctvD[i]);
  				break;
  			case 2:
  				go(y, x, cctvD[i]);
  				go(y, x, (cctvD[i] + 2) % 4);  			
  				break;
  			case 3:
  				go(y, x, cctvD[i]);
  				go(y, x, (cctvD[i] + 1) % 4);  			
  				break;
  			case 4:
  				go(y, x, cctvD[i]);
  				go(y, x, (cctvD[i] + 1) % 4);  			
  				go(y, x, (cctvD[i] + 2) % 4);  			
  				break;
  			case 5:
  				go(y, x, cctvD[i]);
  				go(y, x, (cctvD[i] + 1) % 4);  			
  				go(y, x, (cctvD[i] + 2) % 4);   		
  				go(y, x, (cctvD[i] + 3) % 4);    
  				break;
  		}
  	}
  	sum = 0;
    for(int i=0; i<n; ++i) {
    	for(int j=0; j<m; ++j) {
    		if(arrTmp[i][j] == 0) {
      		++sum;    			
    		}
    	}
    }
 
    ans = Math.min(ans,  sum);
  }
  public static void go(int y, int x, int d) {
  	int nextY = y + dy[d];
  	int nextX = x + dx[d];
		if(nextY >= 0 && nextY < n && nextX >= 0 && nextX < m) {
			if(arrTmp[nextY][nextX] == 6) {
				return;
			}
			if(arrTmp[nextY][nextX] == 0) {
				arrTmp[nextY][nextX] = 7;
			}
			go(nextY, nextX, d);
  	}
  }
}