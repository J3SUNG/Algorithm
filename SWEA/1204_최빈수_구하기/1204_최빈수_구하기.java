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
            int index = 0;
            int max = 0;
            int[] arr = new int[101];
            for(int i=0; i<1000; ++i){
                n = sc.nextInt();
                ++arr[n];
            }
            for(int i=0; i<101; ++i){
                if(max <= arr[i]){
                    max = arr[i];
                    index = i;
                }
            }
            System.out.printf("#%d %d%n", test_case, index);
        }
    }
}