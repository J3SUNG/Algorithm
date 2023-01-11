import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        int result = 0;
        char c;
        String s;
        T=sc.nextInt();
        s=sc.nextLine();
         
        for(int test_case = 1; test_case <= T; test_case++)
        {
            c = '0';
            result = 0;
            s=sc.nextLine();
            for(int i=0; i<s.length(); ++i) {
                if(c == s.charAt(i)) {
                    continue;
                }
                else {
                    c = s.charAt(i);
                    ++result;
                }
            }
            System.out.println("#" + test_case + " " + result);
        }
    }
}