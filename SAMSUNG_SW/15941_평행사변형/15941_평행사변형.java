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
            System.out.printf("#%d %d%n", test_case, n*n);
		}
	}
}