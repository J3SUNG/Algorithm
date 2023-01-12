import java.util.Scanner;
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
            int ans = 0;
            int n = sc.nextInt();
            int m = sc.nextInt();
            int temp;
            int sum;
            int mul;
            boolean chk = false;
            if(n > m){
                temp = n;
                n = m;
                m = temp;
                chk = true;
            }
            int[] small = new int[n];
            int[] big = new int[m];
             
            if(!chk){
                for(int i=0; i<small.length; ++i){
                    small[i] = sc.nextInt();   
                }
                for(int i=0; i<big.length; ++i){
                    big[i] = sc.nextInt();   
                }
            } else {
                for(int i=0; i<big.length; ++i){
                    big[i] = sc.nextInt();   
                }
                for(int i=0; i<small.length; ++i){
                    small[i] = sc.nextInt();   
                }
            }
             
            for(int i=0; i<m-n+1; ++i){
                sum = 0;
                for(int j=0; j<n; ++j){
                    mul = small[j] * big[i+j];
                    sum += mul;      
                }                
                ans = Math.max(sum, ans);
            }
            System.out.printf("#%d %d%n", test_case, ans);
        }
    }
}