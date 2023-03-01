import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {       
        Scanner sc = new Scanner(System.in);
 
        int ans = 0;
        int n = sc.nextInt();
        while(n != 0){
            ans += n % 10;
            n /= 10;
        }
        System.out.printf("%d", ans);
    }
}