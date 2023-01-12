import java.util.*;
import java.io.FileInputStream;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {       
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0; i<n; ++i){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.printf("%d", arr[n/2]);
    }
}