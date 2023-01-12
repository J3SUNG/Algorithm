import java.awt.Point;
import java.util.*;
import java.io.FileInputStream;
  
class Solution
{
    public static void main(String args[]) throws Exception
    {       
        Scanner sc = new Scanner(System.in);
        int T;
        T=10;
          
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int y, x;
            int[][] arr = new int[100][100];
            String s = sc.nextLine();
            int[] moveX = {0, 1, 0, -1};
            int[] moveY = {1, 0, -1, 0};
            boolean chk = false;
            Point p;
            Queue<Point> queue = new LinkedList<>();
            for(int i=0; i<100; ++i){
                s = sc.nextLine();
                for(int j=0; j<100; ++j){
                    arr[i][j] = Integer.parseInt(s.substring(j,j+1));
                    if(arr[i][j] == 2){
                        queue.add(new Point(i, j));   
                    }
                }
            }
              
            while(!queue.isEmpty()){
                p = queue.poll();
                y = p.x;
                x = p.y;
                for(int i=0; i<4; ++i){
                    if(arr[y+moveY[i]][x+moveX[i]] == 0){
                        arr[y+moveY[i]][x+moveX[i]] = 1;
                        queue.add(new Point(y+moveY[i], x+moveX[i]));   
                    }
                    if(arr[y+moveY[i]][x+moveX[i]] == 3){
                        chk = true;
                        while(!queue.isEmpty()){
                            queue.poll();   
                        }
                    }
                }
            }
            if(chk){
                System.out.printf("#%d 1%n", test_case);
            } else {
                System.out.printf("#%d 0%n", test_case);
            }
        }
    }
}