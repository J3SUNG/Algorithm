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
            int m = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int x, y;
            int next1 = 0;
            int next2 = 0;
            int num;
            int ans1, ans2 = 0;
            int[][] tb = new int[n+1][2]; 
            int[] bt = new int[n+1];
            int[] visit = new int[n+1];
            Queue<Integer> q = new LinkedList<Integer>();
             
            for(int i=0; i<m; ++i){
                x = sc.nextInt();
                y = sc.nextInt();
                if(tb[x][0] == 0){
                    tb[x][0] = y;    
                } else {
                    tb[x][1] = y;    
                }
                bt[y] = x;
            }
            x=a;
            y=b;
            visit[x] = 1;
            visit[y] = 1;
            while(true){
                if(bt[x] != 0){
                    next1 = bt[x];
                    if(visit[next1] == 1){
                        ans1 = next1;
                        break;
                    }
                    visit[next1] = 1;
                } 
                if(bt[y] != 0){
                    next2 = bt[y];
                    if(visit[next2] == 1){
                        ans1 = next2;
                        break;
                    }
                    visit[next2] = 1;
                }                
                x=next1;
                y=next2;
            }
            q.add(ans1);
            while(!q.isEmpty()){
                ++ans2;
                num = q.poll();
                if(tb[num][0] == 0){
                    continue;   
                } else {
                    q.add(tb[num][0]);
                }
                if(tb[num][1] == 0){
                    continue;   
                } else {
                    q.add(tb[num][1]);
                }
            }
            System.out.printf("#%d %d %d%n", test_case, ans1, ans2);
        }
    }
}