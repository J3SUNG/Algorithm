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
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            for(int i=0; i<n; ++i){
                for(int j=0; j<n; ++j){
                       arr[i][j]=sc.nextInt();
                }
            }
            System.out.printf("#%d %n", test_case);   
            for(int i=0; i<n; ++i){
                for(int j=0; j<n; ++j){
                    System.out.printf("%d", arr[n-j-1][i]);   
                }
                System.out.printf(" ");   
                for(int j=0; j<n; ++j){
                    System.out.printf("%d", arr[n-i-1][n-j-1]);   
                }
                System.out.printf(" ");   
                for(int j=0; j<n; ++j){
                    System.out.printf("%d", arr[j][n-i-1]);   
                }
                System.out.printf("%n");   
            }
        }
    }
}