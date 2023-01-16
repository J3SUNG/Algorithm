import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = 10;
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n;
            int answer = 0;
            int left, right;
            int[] arr = new int[1000];
             
            n = sc.nextInt();
             
            for(int i=0; i<n; ++i){
                arr[i] = sc.nextInt();
            }
            for(int i=2; i<n-2; ++i){
                if(arr[i] > arr[i-1] && arr[i] > arr[i-2]){
                    left = Math.max(arr[i-1], arr[i-2]);   
                } else {
                    continue;
                }
                if(arr[i] > arr[i+1] && arr[i] > arr[i+2]){
                    right = Math.max(arr[i+1], arr[i+2]);   
                } else {
                    continue;
                }
                //System.out.printf("!!%d %d %d%n", arr[i], Math.max(left, right), arr[i] - Math.max(left, right));    
                answer += arr[i] - Math.max(left, right);
            }
            System.out.printf("#%d %d%n", test_case, answer);
        }
    }
}