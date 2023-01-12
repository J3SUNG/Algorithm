import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int a, b;
         
        a = sc.nextInt();
        b = sc.nextInt();
        // 1가위 2바위 3보
        if((a==1 && b==2) || (a==2 && b==3) || (a==3 && b==1)){
            System.out.printf("B");
        } else {
            System.out.printf("A");
        }
    }
}